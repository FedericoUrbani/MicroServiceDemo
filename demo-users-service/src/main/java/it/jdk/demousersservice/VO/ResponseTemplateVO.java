package it.jdk.demousersservice.VO;

import it.jdk.demousersservice.model.Users;
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
