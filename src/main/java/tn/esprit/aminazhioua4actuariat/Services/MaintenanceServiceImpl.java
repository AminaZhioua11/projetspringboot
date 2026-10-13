package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Maintenance;
import tn.esprit.aminazhioua4actuariat.repository.MaintenanceRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        maintenance.setIdMaintenance(null);
        maintenance.setVehicule(null);
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Set<Maintenance> afficherMaintenances() {
        return new HashSet<>(maintenanceRepository.findAll());
    }

    @Override
    public Maintenance afficherMaintenance(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Maintenance introuvable"
                ));
    }

    @Override
    public Maintenance modifierMaintenance(
            Long id, Maintenance maintenance) {

        Maintenance existante = afficherMaintenance(id);

        existante.setDateDebut(maintenance.getDateDebut());
        existante.setDateFin(maintenance.getDateFin());
        existante.setDescription(maintenance.getDescription());

        return maintenanceRepository.save(existante);
    }

    @Override
    public void supprimerMaintenance(Long id) {
        Maintenance maintenance = afficherMaintenance(id);
        maintenanceRepository.delete(maintenance);
    }
}