package edu.hightech.quiztech.dto.response;

import edu.hightech.quiztech.entity.enums.CategorieAudit;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogResponse {
    private Long id;
    private LocalDateTime dateAction;
    private String action;
    private String details;
    private CategorieAudit categorie;
    private String userName; // باش يبان سمية الـ User اللي دار الـ Action ف الـ Dashboard
}