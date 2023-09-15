package it.jdk.demousersservice.repository;


import it.jdk.demousersservice.model.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepository {

    private List<Users> users
            = new ArrayList<>();

    public Users add(Users user) {
        users.add(user);
        return user;
    }

    public Users findById(Long id) {
        return users.stream()
                .filter(a -> a.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Users> findAll() {
        return users;
    }

    public List<Users> findByDepartment(Long departmentId) {
        return users.stream()
                .filter(a -> a.departmentId().equals(departmentId))
                .toList();
    }
}