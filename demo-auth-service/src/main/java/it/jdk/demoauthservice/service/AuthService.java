package it.jdk.demoauthservice.service;

import it.jdk.demoauthservice.model.UserCredential;
import it.jdk.demoauthservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserCredentialRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential userCrential){
        userCrential.setPassword(passwordEncoder.encode(userCrential.getPassword()));
        repository.save(userCrential);
        return "user added to db";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
