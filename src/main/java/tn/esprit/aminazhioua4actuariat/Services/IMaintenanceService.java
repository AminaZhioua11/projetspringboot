package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Maintenance;

import java.util.Set;

public interface IMaintenanceService {

    Maintenance ajouterMaintenance(Maintenance maintenance);

    Set<Maintenance> afficherMaintenances();

    Maintenance afficherMaintenance(Long id);

    Maintenance modifierMaintenance(Long id, Maintenance maintenance);

    void supprimerMaintenance(Long id);
}