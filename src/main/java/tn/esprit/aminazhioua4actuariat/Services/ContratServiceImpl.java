package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Contrat;
import tn.esprit.aminazhioua4actuariat.repository.ContratRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final ContratRepository contratRepository;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        contrat.setIdContrat(null);
        contrat.setReservation(null);
        contrat.setPaiements(new HashSet<>());

        return contratRepository.save(contrat);
    }

    @Override
    public Set<Contrat> afficherContrats() {
        return new HashSet<>(contratRepository.findAll());
    }

    @Override
    public Contrat afficherContrat(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Contrat introuvable"
                ));
    }

    @Override
    public Contrat modifierContrat(Long id, Contrat contrat) {
        Contrat existant = afficherContrat(id);

        existant.setDateSignature(contrat.getDateSignature());
        existant.setMontantTotal(contrat.getMontantTotal());
        existant.setValide(contrat.isValide());

        return contratRepository.save(existant);
    }

    @Override
    public void supprimerContrat(Long id) {
        Contrat contrat = afficherContrat(id);
        contratRepository.delete(contrat);
    }
}