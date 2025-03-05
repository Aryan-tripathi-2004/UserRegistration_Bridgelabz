package com.example.UserRegistration.Service;

import com.example.UserRegistration.DTO.AuthUserDTO;
import com.example.UserRegistration.DTO.LoginDTO;
import com.example.UserRegistration.Exception.UserException;
import com.example.UserRegistration.Model.AuthUser;

public interface IAuthenticationService {
    AuthUser register(AuthUserDTO userDTO) throws Exception;
    String login(LoginDTO loginDTO) throws UserException;
}
