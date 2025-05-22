package com.dealsapp.userservice.service;

import com.dealsapp.userservice.dto.JWTResponse;
import com.dealsapp.userservice.dto.UserDTO;
import com.dealsapp.userservice.dto.UserLoginRequest;
import com.dealsapp.userservice.dto.UserRegisterRequest;
import com.dealsapp.userservice.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String registerUser(UserRegisterRequest request);
    JWTResponse loginUser(UserLoginRequest request);
    String updateUser(Long id, UserRegisterRequest request);
    String deleteUser(Long id);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();

}

