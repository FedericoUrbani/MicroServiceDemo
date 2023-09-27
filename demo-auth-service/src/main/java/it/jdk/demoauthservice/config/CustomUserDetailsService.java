package it.jdk.demoauthservice.config;

import com.netflix.discovery.converters.Auto;
import it.jdk.demoauthservice.model.UserCredential;
import it.jdk.demoauthservice.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserCredential> credential=repository.findByName(username);
        return credential.map(CustomUserDetails::new).orElseThrow(()->new RuntimeException("user not found with name:"+ username));
    }
}
