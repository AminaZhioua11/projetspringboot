package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Contrat;
import java.util.Set;

public interface IContratService {

    Contrat ajouterContrat(Contrat contrat);

    Set<Contrat> afficherContrats();

    Contrat afficherContrat(Long id);

    Contrat modifierContrat(Long id, Contrat contrat);

    void supprimerContrat(Long id);
}