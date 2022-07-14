package com.tutorial.crudmongoback.security.service;

import com.tutorial.crudmongoback.CRUD.entity.Product;
import com.tutorial.crudmongoback.global.exceptions.AttributeException;
import com.tutorial.crudmongoback.global.utils.Operations;
import com.tutorial.crudmongoback.security.dto.CreateUserDto;
import com.tutorial.crudmongoback.security.entity.UserEntity;
import com.tutorial.crudmongoback.security.enums.RoleEnum;
import com.tutorial.crudmongoback.security.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserEntityService {

    @Autowired
    UserEntityRepository userEntityRepository;

    public UserEntity create(CreateUserDto dto) throws AttributeException {
        if(userEntityRepository.existsByUsername(dto.getUsername()))
            throw new AttributeException("username already in use");
        if(userEntityRepository.existsByEmail(dto.getEmail()))
            throw new AttributeException("email already in use");
        return userEntityRepository.save(mapUserFromDto(dto));
    }

    // private methods
    private UserEntity mapUserFromDto(CreateUserDto dto) {
        int id = Operations.autoIncrement(userEntityRepository.findAll());
        List<RoleEnum> roles =
                dto.getRoles().stream().map(rol -> RoleEnum.valueOf(rol)).collect(Collectors.toList());
        return new UserEntity(id, dto.getUsername(), dto.getEmail(), dto.getPassword(), roles);
    }
}
