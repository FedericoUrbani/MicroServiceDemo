package it.jdk.demoauthservice.controller;

import com.netflix.discovery.converters.Auto;
import it.jdk.demoauthservice.dto.AuthRequest;
import it.jdk.demoauthservice.model.UserCredential;
import it.jdk.demoauthservice.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@Slf4j
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user){
        log.info("inside add new user");
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        log.info("inside gettoken"+ authenticate);
        if(authenticate.isAuthenticated()){
            return service.generateToken(authRequest.getUsername());
        }else{
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String getToken(@RequestParam("token") String token){
        service.validateToken(token);
        return "Token is valid";
    }
}
