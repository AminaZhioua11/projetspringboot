package tn.esprit.aminazhioua4actuariat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IPaiementService;
import tn.esprit.aminazhioua4actuariat.entity.Paiement;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paiement")
public class PaiementRestController {

    private final IPaiementService paiementService;

    @PostMapping("/ajouter")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @GetMapping("/tous")
    public Set<Paiement> afficherPaiements() {
        return paiementService.afficherPaiements();
    }

    @GetMapping("/{id}")
    public Paiement afficherPaiement(@PathVariable("id") Long id) {
        return paiementService.afficherPaiement(id);
    }

    @PutMapping("/{id}")
    public Paiement modifierPaiement(
            @PathVariable("id") Long id,
            @RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(id, paiement);
    }

    @DeleteMapping("/{id}")
    public void supprimerPaiement(@PathVariable("id") Long id) {
        paiementService.supprimerPaiement(id);
    }
}