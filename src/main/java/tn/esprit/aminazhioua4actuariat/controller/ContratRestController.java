package tn.esprit.aminazhioua4actuariat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IContratService;
import tn.esprit.aminazhioua4actuariat.entity.Contrat;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
@Tag(name = "Gestion des contrats")
public class ContratRestController {

    private final IContratService contratService;

    @PostMapping("/ajouter")
    @Operation(summary = "Ajouter un contrat")
    public Contrat ajouter(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @GetMapping("/tous")
    @Operation(summary = "Afficher tous les contrats")
    public Set<Contrat> afficherTous() {
        return contratService.afficherContrats();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Afficher un contrat")
    public Contrat afficherUn(@PathVariable("id") Long id) {
        return contratService.afficherContrat(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un contrat")
    public Contrat modifier(
            @PathVariable("id") Long id,
            @RequestBody Contrat contrat) {
        return contratService.modifierContrat(id, contrat);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un contrat")
    public void supprimer(@PathVariable("id") Long id) {
        contratService.supprimerContrat(id);
    }
}