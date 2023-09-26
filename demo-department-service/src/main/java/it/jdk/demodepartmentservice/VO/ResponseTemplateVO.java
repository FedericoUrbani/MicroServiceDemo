package it.jdk.demodepartmentservice.VO;

import it.jdk.demodepartmentservice.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {
    private Users user;
    private Department department;

}
