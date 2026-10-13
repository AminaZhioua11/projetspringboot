package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Vehicule;
import java.util.Set;

public interface IVehiculeService {

    Vehicule ajouterVehicule(Vehicule vehicule);

    Set<Vehicule> afficherVehicules();

    Vehicule afficherVehicule(Long id);

    Vehicule modifierVehicule(Long id, Vehicule vehicule);

    void supprimerVehicule(Long id);
}