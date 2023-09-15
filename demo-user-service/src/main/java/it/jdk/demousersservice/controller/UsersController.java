package it.jdk.demousersservice.controller;

import it.jdk.demousersservice.model.Users;
import it.jdk.demousersservice.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UsersRepository repository;

    @PostMapping
    public Users add(@RequestBody Users users) {
        LOGGER.info("Employee add: {}", users);
        return repository.add(users);
    }

    @GetMapping
    public List<Users> findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Users> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Employee find: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }

}
