package it.jdk.demodepartmentservice.client;

import it.jdk.demodepartmentservice.domain.Users;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface UsersClient {

    @GetExchange("/employee/department/{departmentId}")
    public List<Users> findByDepartment(@PathVariable("departmentId") Long departmentId);

}