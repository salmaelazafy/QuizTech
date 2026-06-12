package edu.hightech.quiztech.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String nomComplet;
    private String email;
    private String role;
    private LocalDate dateInscription;
    private String status;
}