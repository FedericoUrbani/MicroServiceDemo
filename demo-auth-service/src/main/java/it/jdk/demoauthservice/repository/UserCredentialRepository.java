package it.jdk.demoauthservice.repository;

import it.jdk.demoauthservice.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends JpaRepository<UserCredential,Long> {

    Optional<UserCredential> findByName(String username);
}
