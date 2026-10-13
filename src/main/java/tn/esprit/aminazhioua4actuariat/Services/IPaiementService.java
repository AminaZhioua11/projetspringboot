package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Paiement;
import java.util.Set;

public interface IPaiementService {

    Paiement ajouterPaiement(Paiement paiement);

    Set<Paiement> afficherPaiements();

    Paiement afficherPaiement(Long id);

    Paiement modifierPaiement(Long id, Paiement paiement);

    void supprimerPaiement(Long id);
}