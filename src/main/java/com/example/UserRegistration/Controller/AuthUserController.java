package com.example.UserRegistration.Controller;

import jakarta.validation.Valid;
import com.example.UserRegistration.DTO.AuthUserDTO;
import com.example.UserRegistration.DTO.LoginDTO;
import com.example.UserRegistration.DTO.ResponseDTO;
import com.example.UserRegistration.Exception.UserException;
import com.example.UserRegistration.Model.AuthUser;
import com.example.UserRegistration.Service.EmailSenderService;
import com.example.UserRegistration.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody AuthUserDTO userDTO) throws Exception{
        AuthUser user=authenticationService.register(userDTO);
        ResponseDTO responseUserDTO =new ResponseDTO("User details is submitted!", user);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) throws UserException {
        String result = authenticationService.login(loginDTO);
        ResponseDTO responseUserDTO=new ResponseDTO("Login successfully!!", result);
        return new ResponseEntity<>(responseUserDTO,HttpStatus.OK);
    }
}