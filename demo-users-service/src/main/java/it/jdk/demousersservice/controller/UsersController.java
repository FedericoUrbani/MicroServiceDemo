package it.jdk.demousersservice.controller;

import it.jdk.demousersservice.VO.ResponseTemplateVO;
import it.jdk.demousersservice.model.Users;
import it.jdk.demousersservice.repository.UsersRepository;
import it.jdk.demousersservice.service.UsersService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UsersController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UsersService service;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        log.info("inside saveUser of userController");
        return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long id){
        log.info("inside getUserWithDepartment of userController");
        return service.getUserWithDepartment(id);
    }


}
