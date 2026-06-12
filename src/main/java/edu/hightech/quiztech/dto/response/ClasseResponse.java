package edu.hightech.quiztech.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClasseResponse {
    private Long id;
    private String nomClasse;
    private int nombreEtudiants;
}