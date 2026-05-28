package com.amitmourya8085.blog.Controller;

import com.amitmourya8085.blog.ApiResponses.ApiResponse;
import com.amitmourya8085.blog.DTO.LoginRequest;
import com.amitmourya8085.blog.DTO.UserRequestDTO;
import com.amitmourya8085.blog.DTO.UserResponseDTO;
import com.amitmourya8085.blog.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ApiResponse<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO request) {

        return new ApiResponse<>(
                "success",
                "User registered successfully",
                userService.registerUser(request)
        );
    }
    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest request){
       return userService.login(request);
    }
}
