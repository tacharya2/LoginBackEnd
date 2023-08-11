package com.Register.Login.mapper;

import com.Register.Login.model.UserDto;
import com.Register.Login.repository.model.UserEntity;
import org.modelmapper.ModelMapper;

public class UserMapper {
    private static ModelMapper modelMapper= new ModelMapper();

    private UserMapper(){

    }
    public static UserDto entityToDto(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDto.class);
    }

    public static UserEntity dtoToEntity(UserDto userDto){
        return modelMapper.map(userDto, UserEntity.class);
    }
}