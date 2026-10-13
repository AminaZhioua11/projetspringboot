package tn.esprit.aminazhioua4actuariat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IAgenceService;
import tn.esprit.aminazhioua4actuariat.entity.Agence;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agence")
@Tag(name = "Gestion des agences")
public class AgenceRestController {

    private final IAgenceService agenceService;

    @PostMapping("/ajouter")
    @Operation(summary = "Ajouter une agence")
    public Agence ajouter(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @GetMapping("/tous")
    @Operation(summary = "Afficher toutes les agences")
    public Set<Agence> afficherToutes() {
        return agenceService.afficherAgences();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Afficher une agence")
    public Agence afficherUne(@PathVariable("id") Long id) {
        return agenceService.afficherAgence(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une agence")
    public Agence modifier(
            @PathVariable("id") Long id,
            @RequestBody Agence agence) {
        return agenceService.modifierAgence(id, agence);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une agence")
    public void supprimer(@PathVariable("id") Long id) {
        agenceService.supprimerAgence(id);
    }
}