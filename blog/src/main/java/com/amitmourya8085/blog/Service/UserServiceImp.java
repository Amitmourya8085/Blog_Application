package com.amitmourya8085.blog.Service;

import com.amitmourya8085.blog.DTO.LoginRequest;
import com.amitmourya8085.blog.DTO.UserRequestDTO;
import com.amitmourya8085.blog.DTO.UserResponseDTO;
import com.amitmourya8085.blog.Entity.User;
import com.amitmourya8085.blog.Repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public UserResponseDTO registerUser(UserRequestDTO request) {
        //VALIDATE EMAIL
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }
           // DTO TO ENTITY
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

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
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if(!userOptional.isEmpty())
            return "user not Found";

        User user = userOptional.get();

        if(!user.getPassword().equals(request.getEmail())){
            return "Invalid Password";
        }

        return "Login Successfully";
    }

}
