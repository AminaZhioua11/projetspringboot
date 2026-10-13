package tn.esprit.aminazhioua4actuariat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IEmployeService;
import tn.esprit.aminazhioua4actuariat.entity.Employe;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employe")
@Tag(name = "Gestion des employes")
public class EmployeRestController {

    private final IEmployeService employeService;

    @PostMapping("/ajouter")
    @Operation(summary = "Ajouter un employe")
    public Employe ajouter(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @GetMapping("/tous")
    @Operation(summary = "Afficher tous les employes")
    public Set<Employe> afficherTous() {
        return employeService.afficherEmployes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Afficher un employe par son identifiant")
    public Employe afficherUn(@PathVariable("id") Long id) {
        return employeService.afficherEmploye(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un employe")
    public Employe modifier(
            @PathVariable("id") Long id,
            @RequestBody Employe employe) {
        return employeService.modifierEmploye(id, employe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un employe")
    public void supprimer(@PathVariable("id") Long id) {
        employeService.supprimerEmploye(id);
    }
}