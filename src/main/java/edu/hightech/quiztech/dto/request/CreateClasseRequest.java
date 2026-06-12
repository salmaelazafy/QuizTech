package edu.hightech.quiztech.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferEtudiantRequest {
    private Long etudiantId; // رجعناه Long ديريكت حيت الـ IDs كاملين Long عند Dev A
    private Long classeId;
}