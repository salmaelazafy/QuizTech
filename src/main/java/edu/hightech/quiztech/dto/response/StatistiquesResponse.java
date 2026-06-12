package edu.hightech.quiztech.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatistiquesResponse {
    private long totalEtudiants;
    private long totalEnseignants;
    private long totalClasses;
    private long totalExamens;
}