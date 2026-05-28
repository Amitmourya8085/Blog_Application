package com.amitmourya8085.blog.Service;

import com.amitmourya8085.blog.DTO.LoginRequest;
import com.amitmourya8085.blog.DTO.UserRequestDTO;
import com.amitmourya8085.blog.DTO.UserResponseDTO;

public interface UserService {
    UserResponseDTO registerUser(UserRequestDTO request);
    String login(LoginRequest request);
}
