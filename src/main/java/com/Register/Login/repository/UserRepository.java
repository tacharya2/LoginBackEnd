package com.Register.Login.repository;

import com.Register.Login.model.UserDto;
import com.Register.Login.repository.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
