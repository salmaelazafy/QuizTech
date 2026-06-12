package edu.hightech.quiztech.dto.request;

import edu.hightech.quiztech.entity.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    private String nomComplet;
    private String email;
    private Role role;
    private String status;
}