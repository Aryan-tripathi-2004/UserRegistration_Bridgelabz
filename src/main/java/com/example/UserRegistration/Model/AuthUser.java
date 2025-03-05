package com.example.UserRegistration.Model;

import com.example.UserRegistration.DTO.AuthUserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String resetToken;

    public AuthUser(AuthUserDTO authDTO) {
        this.firstName = authDTO.getFirstName();
        this.lastName = authDTO.getLastName();
        this.email = authDTO.getEmail();
        this.password = authDTO.getPassword();
    }
}
