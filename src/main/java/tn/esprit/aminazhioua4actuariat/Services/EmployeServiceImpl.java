package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Employe;
import tn.esprit.aminazhioua4actuariat.repository.EmployeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;

    @Override
    public Employe ajouterEmploye(Employe employe) {
        employe.setIdEmploye(null);
        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override
    public Set<Employe> afficherEmployes() {
        return new HashSet<>(employeRepository.findAll());
    }

    @Override
    public Employe afficherEmploye(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Employe introuvable"
                ));
    }

    @Override
    public Employe modifierEmploye(Long id, Employe employe) {
        Employe existant = afficherEmploye(id);

        existant.setNom(employe.getNom());
        existant.setPrenom(employe.getPrenom());
        existant.setRole(employe.getRole());

        return employeRepository.save(existant);
    }

    @Override
    public void supprimerEmploye(Long id) {
        Employe employe = afficherEmploye(id);
        employeRepository.delete(employe);
    }
}