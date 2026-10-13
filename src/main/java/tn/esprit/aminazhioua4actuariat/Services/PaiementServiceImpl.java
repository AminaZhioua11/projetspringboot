package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Paiement;
import tn.esprit.aminazhioua4actuariat.repository.PaiementRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final PaiementRepository paiementRepository;

    @Override
    public Paiement ajouterPaiement(Paiement paiement) {
        paiement.setIdPaiement(null);
        paiement.setContrat(null);

        return paiementRepository.save(paiement);
    }

    @Override
    public Set<Paiement> afficherPaiements() {
        return new HashSet<>(paiementRepository.findAll());
    }

    @Override
    public Paiement afficherPaiement(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Paiement introuvable"
                ));
    }

    @Override
    public Paiement modifierPaiement(Long id, Paiement paiement) {
        Paiement existant = afficherPaiement(id);

        existant.setMontant(paiement.getMontant());
        existant.setDatePaiement(paiement.getDatePaiement());
        existant.setModePaiement(paiement.getModePaiement());

        return paiementRepository.save(existant);
    }

    @Override
    public void supprimerPaiement(Long id) {
        Paiement paiement = afficherPaiement(id);
        paiementRepository.delete(paiement);
    }
}