package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Agence;
import java.util.Set;

public interface IAgenceService {

    Agence ajouterAgence(Agence agence);

    Set<Agence> afficherAgences();

    Agence afficherAgence(Long id);

    Agence modifierAgence(Long id, Agence agence);

    void supprimerAgence(Long id);
}