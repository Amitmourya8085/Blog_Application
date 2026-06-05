package com.amitmourya8085.blog.Service;

import com.amitmourya8085.blog.DTO.LoginRequest;
import com.amitmourya8085.blog.DTO.UserRequestDTO;
import com.amitmourya8085.blog.DTO.UserResponseDTO;
import com.amitmourya8085.blog.Entity.User;
import com.amitmourya8085.blog.Repositary.UserRepository;
import com.amitmourya8085.blog.config.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private User user;

    @Autowired
    private JwtUtil jwtUtil;



    @Override
    public UserResponseDTO registerUser(UserRequestDTO request) {
        //VALIDATE EMAIL

        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Email already exists");
        }
           // DTO TO ENTITY
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saved = userRepository.save(user);
            //ENTITY TO DTO
        return new UserResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }


    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // Generate JWT Token
        return jwtUtil.generateToken(user.getEmail());
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(user ->new UserResponseDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }

}
