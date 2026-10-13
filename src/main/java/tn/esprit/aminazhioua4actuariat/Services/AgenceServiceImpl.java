package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Agence;
import tn.esprit.aminazhioua4actuariat.repository.AgenceRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final AgenceRepository agenceRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        agence.setIdAgence(null);
        return agenceRepository.save(agence);
    }

    @Override
    public Set<Agence> afficherAgences() {
        return new HashSet<>(agenceRepository.findAll());
    }

    @Override
    public Agence afficherAgence(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agence introuvable"
                ));
    }

    @Override
    public Agence modifierAgence(Long id, Agence agence) {
        Agence existante = afficherAgence(id);

        existante.setNom(agence.getNom());
        existante.setVille(agence.getVille());
        existante.setAdresse(agence.getAdresse());
        existante.setTelephone(agence.getTelephone());

        return agenceRepository.save(existante);
    }

    @Override
    public void supprimerAgence(Long id) {
        Agence agence = afficherAgence(id);
        agenceRepository.delete(agence);
    }
}