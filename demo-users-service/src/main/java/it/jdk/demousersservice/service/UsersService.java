package it.jdk.demousersservice.service;

import it.jdk.demousersservice.VO.Department;
import it.jdk.demousersservice.VO.ResponseTemplateVO;
import it.jdk.demousersservice.model.Users;
import it.jdk.demousersservice.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {
        log.info("inside saveUser of userService");
        return repository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside getUserWithDepartment of userService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Users user = repository.findById(userId).orElseThrow();
        Department department=
                restTemplate.getForObject("http://localhost:8060/department/"+ user.getDepartmentId(),Department.class);

        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
