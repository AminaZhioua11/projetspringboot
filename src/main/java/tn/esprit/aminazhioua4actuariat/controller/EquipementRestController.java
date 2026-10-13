package tn.esprit.aminazhioua4actuariat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IEquipementService;
import tn.esprit.aminazhioua4actuariat.entity.Equipement;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipement")
public class EquipementRestController {

    private final IEquipementService equipementService;

    @PostMapping("/ajouter")
    public Equipement ajouterEquipement(
            @RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @GetMapping("/tous")
    public Set<Equipement> afficherEquipements() {
        return equipementService.afficherEquipements();
    }

    @GetMapping("/{id}")
    public Equipement afficherEquipement(@PathVariable("id") Long id) {
        return equipementService.afficherEquipement(id);
    }

    @PutMapping("/{id}")
    public Equipement modifierEquipement(
            @PathVariable("id") Long id,
            @RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(id, equipement);
    }

    @DeleteMapping("/{id}")
    public void supprimerEquipement(@PathVariable("id") Long id) {
        equipementService.supprimerEquipement(id);
    }
}