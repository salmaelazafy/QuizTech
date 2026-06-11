package edu.hightech.quiztech.service;

import edu.hightech.quiztech.dto.mapper.ClasseMapper;
import edu.hightech.quiztech.dto.request.CreateClasseRequest;
import edu.hightech.quiztech.dto.request.TransferEtudiantRequest;
import edu.hightech.quiztech.dto.response.ClasseResponse;
import edu.hightech.quiztech.entity.Classe;
import edu.hightech.quiztech.entity.Etudiant;
import edu.hightech.quiztech.repository.ClasseRepository;
import edu.hightech.quiztech.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private ClasseMapper classeMapper; // هنا حقنا الـ Mapper الجديد د الأقسام

    // 1. Créer une nouvelle classe
    public ClasseResponse createClasse(CreateClasseRequest request) {
        if (classeRepository.existsByNomClasse(request.getNomClasse())) {
            throw new RuntimeException("Cette classe existe déjà !");
        }

        Classe classe = new Classe();
        classe.setNomClasse(request.getNomClasse());

        Classe savedClasse = classeRepository.save(classe);
        return classeMapper.toResponse(savedClasse); // التحويل باستعمال الـ Mapper
    }

    // 2. Modifier le nom d'une classe
    public ClasseResponse updateClasse(Long id, CreateClasseRequest request) {
        Classe classe = classeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée !"));

        classe.setNomClasse(request.getNomClasse());

        Classe updatedClasse = classeRepository.save(classe);
        return classeMapper.toResponse(updatedClasse); // التحويل باستعمال الـ Mapper
    }

    // 3. Supprimer une classe
    public void deleteClasse(Long id) {
        if (!classeRepository.existsById(id)) {
            throw new RuntimeException("Classe non trouvée !");
        }
        classeRepository.deleteById(id);
    }

    // 4. Afficher toutes les classes
    public List<ClasseResponse> getAllClasses() {
        return classeRepository.findAll().stream()
                .map(classeMapper::toResponse) // تحويل الـ List كاملة باستعمال الـ Mapper
                .collect(Collectors.toList());
    }

    // 5. Transférer ou affecter un étudiant à une classe
    public void transferEtudiant(TransferEtudiantRequest request) {
        Etudiant etudiant = (Etudiant) utilisateurRepository.findById(request.getEtudiantId())
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé !"));

        Classe classe = classeRepository.findById(request.getClasseId())
                .orElseThrow(() -> new RuntimeException("Classe non trouvée !"));

        etudiant.setClasse(classe);
        utilisateurRepository.save(etudiant);
    }
}