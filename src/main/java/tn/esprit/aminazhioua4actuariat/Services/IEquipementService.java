package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Equipement;

import java.util.Set;

public interface IEquipementService {

    Equipement ajouterEquipement(Equipement equipement);

    Set<Equipement> afficherEquipements();

    Equipement afficherEquipement(Long id);

    Equipement modifierEquipement(Long id, Equipement equipement);

    void supprimerEquipement(Long id);
}