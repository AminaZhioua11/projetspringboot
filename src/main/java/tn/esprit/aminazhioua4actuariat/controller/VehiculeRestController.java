package tn.esprit.aminazhioua4actuariat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IVehiculeService;
import tn.esprit.aminazhioua4actuariat.entity.Vehicule;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicule")
@Tag(name = "Gestion des vehicules")
public class VehiculeRestController {

    private final IVehiculeService vehiculeService;

    @PostMapping("/ajouter")
    @Operation(summary = "Ajouter un vehicule")
    public Vehicule ajouter(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @GetMapping("/tous")
    @Operation(summary = "Afficher tous les vehicules")
    public Set<Vehicule> afficherTous() {
        return vehiculeService.afficherVehicules();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Afficher un vehicule")
    public Vehicule afficherUn(@PathVariable("id") Long id) {
        return vehiculeService.afficherVehicule(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un vehicule")
    public Vehicule modifier(
            @PathVariable("id") Long id,
            @RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(id, vehicule);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un vehicule")
    public void supprimer(@PathVariable("id") Long id) {
        vehiculeService.supprimerVehicule(id);
    }
}