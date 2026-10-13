package tn.esprit.aminazhioua4actuariat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IMaintenanceService;
import tn.esprit.aminazhioua4actuariat.entity.Maintenance;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceRestController {

    private final IMaintenanceService maintenanceService;

    @PostMapping("/ajouter")
    public Maintenance ajouterMaintenance(
            @RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @GetMapping("/tous")
    public Set<Maintenance> afficherMaintenances() {
        return maintenanceService.afficherMaintenances();
    }

    @GetMapping("/{id}")
    public Maintenance afficherMaintenance(
            @PathVariable("id") Long id) {
        return maintenanceService.afficherMaintenance(id);
    }

    @PutMapping("/{id}")
    public Maintenance modifierMaintenance(
            @PathVariable("id") Long id,
            @RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(id, maintenance);
    }

    @DeleteMapping("/{id}")
    public void supprimerMaintenance(@PathVariable("id") Long id) {
        maintenanceService.supprimerMaintenance(id);
    }
}