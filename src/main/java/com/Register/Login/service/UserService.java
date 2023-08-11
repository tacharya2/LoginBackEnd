package com.Register.Login.service;

import com.Register.Login.mapper.UserMapper;
import com.Register.Login.model.UserDto;
import com.Register.Login.repository.UserRepository;
import com.Register.Login.repository.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public UserDto createUser(UserDto userDto){
        String hashedPassword = hashedPassword(userDto.getPassword());

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(hashedPassword);

        try{
            UserEntity savedUserEntity = userRepository.save(userEntity);
            return UserMapper.entityToDto(savedUserEntity);
        }catch(DataIntegrityViolationException e){
            throw new IllegalArgumentException("Failed to create user for " + userDto.getName() + ". Please try again");
        }
    }

    private String hashedPassword(String password) {
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(password.getBytes());

            //convert the hash bytes to a hexadecimal string
            StringBuilder hashBuilder = new StringBuilder();
            for(byte hashByte : hashBytes){
                hashBuilder.append(Integer.toHexString((hashByte & 0xFF) | 0x100).substring(1, 3));
            }
            return hashBuilder.toString();
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Hashing Algorithm not available");
        }
    }
}