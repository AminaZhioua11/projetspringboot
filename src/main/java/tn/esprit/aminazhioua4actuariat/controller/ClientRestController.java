package tn.esprit.aminazhioua4actuariat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IClientService;
import tn.esprit.aminazhioua4actuariat.entity.Client;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@Tag(name = "Gestion des clients")
public class ClientRestController {

    private final IClientService clientService;

    @PostMapping("/ajouter")
    @Operation(summary = "Ajouter un client")
    public Client ajouter(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @GetMapping("/tous")
    @Operation(summary = "Afficher tous les clients")
    public Set<Client> afficherTous() {
        return clientService.afficherClients();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Afficher un client par son identifiant")
    public Client afficherUn(@PathVariable("id") Long id) {
        return clientService.afficherClient(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier un client")
    public Client modifier(
            @PathVariable("id") Long id,
            @RequestBody Client client) {
        return clientService.modifierClient(id, client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un client")
    public void supprimer(@PathVariable("id") Long id) {
        clientService.supprimerClient(id);
    }
}