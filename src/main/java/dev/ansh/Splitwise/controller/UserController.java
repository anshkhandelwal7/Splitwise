package dev.ansh.Splitwise.controller;

import dev.ansh.Splitwise.dto.UserLoginRequestDTO;
import dev.ansh.Splitwise.dto.UserRegistrationRequestDTO;
import dev.ansh.Splitwise.entity.User;
import dev.ansh.Splitwise.exception.UserRegistrationInvalidDataException;
import dev.ansh.Splitwise.mapper.EntityDTOMapper;
import dev.ansh.Splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO) {
        validateUserRegistrationRequestDTO(userRegistrationRequestDTO);
        User savedUser = userService.signup(userRegistrationRequestDTO.getName(), userRegistrationRequestDTO.getEmail(), userRegistrationRequestDTO.getPassword());
        return ResponseEntity.ok(
                EntityDTOMapper.toDTO(savedUser)
        );
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        validateUserLoginRequestDTO(userLoginRequestDTO);
        User savedUser = userService.login(userLoginRequestDTO.getEmail(), userLoginRequestDTO.getPassword());
        return ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser));
    }
        private void validateUserRegistrationRequestDTO(UserRegistrationRequestDTO requestDTO){
        if(requestDTO.getEmail() == null ||
                requestDTO.getName() == null ||
                requestDTO.getPassword() == null){
            throw new UserRegistrationInvalidDataException("Invalid sign up data");
        }
    }
    private void validateUserLoginRequestDTO(UserLoginRequestDTO userLoginRequestDTO){

    }
}
