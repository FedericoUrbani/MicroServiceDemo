package it.jdk.demodepartmentservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    Long id;
    Long departmentId;
    String name;
    int age;

}
