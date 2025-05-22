package com.dealsapp.userservice.service;

import com.dealsapp.userservice.config.JWTUtil;
import com.dealsapp.userservice.dto.*;
//import com.dealsapp.userservice.exception.EmailAlreadyExistsException;
//import com.dealsapp.userservice.exception.UserNotFoundException;
import com.dealsapp.userservice.model.Role;
import com.dealsapp.userservice.model.UserEntity;
import com.dealsapp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;


    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public UserServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder, JWTUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String registerUser(UserRegisterRequest request) {
        if (userRepo.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }

        Role role = Role.valueOf(request.getRole().toUpperCase());

        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        NotificationRequest loginNotification = new NotificationRequest(
                user.getEmail(),
                "Login Successful",
                "Hi " + user.getUsername() + ", you have successfully logged into DealsApp!"
        );

        try {
            restTemplate.postForObject(
                    "http://NOTIFICATION-SERVICE/api/notifications/send",
                    loginNotification,
                    String.class
            );
        } catch (Exception e) {
            System.out.println("Notification failed: " + e.getMessage());
        }



        userRepo.save(user);
        return "User registered successfully!";




    }



    @Override
    public JWTResponse loginUser(UserLoginRequest request) {
        System.out.println("Login attempt for: " + request.getEmail());

        Optional<UserEntity> userOpt = userRepo.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            System.out.println("Email not found: " + request.getEmail());
            throw new RuntimeException("Invalid email or password");
        }

        UserEntity user = userOpt.get();

        System.out.println("Hashed password from DB: " + user.getPassword());
        System.out.println("Plain password from login: " + request.getPassword());

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        System.out.println("Password match result: " + matches);

        if (!matches) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());



        NotificationRequest loginNotification = new NotificationRequest(
                user.getEmail(),
                "Login Successful",
                "Hi " + user.getUsername() + ", you have successfully logged into DealsApp!"
        );

        try {
            restTemplate.postForObject(
                    "http://localhost:8082/api/notifications/send",
                    new Object(),
                    String.class
            );
        } catch (Exception e) {
            System.out.println("Notification failed: " + e.getMessage());
        }


        return new JWTResponse(token, user.getRole().name());
    }




    @Override
    public String updateUser(Long id, UserRegisterRequest request) {
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        user.setRole(Role.valueOf(request.getRole().toUpperCase()));
        userRepo.save(user);

        return "User updated successfully!";
    }

    @Override
    public String deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepo.deleteById(id);
        return "User deleted successfully!";
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }




    private UserDTO convertToDTO(UserEntity user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

}

