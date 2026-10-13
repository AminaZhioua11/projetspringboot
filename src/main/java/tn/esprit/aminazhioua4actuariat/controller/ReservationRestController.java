package tn.esprit.aminazhioua4actuariat.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aminazhioua4actuariat.Services.IReservationService;
import tn.esprit.aminazhioua4actuariat.entity.Reservation;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
@Tag(name = "Gestion des reservations")
public class ReservationRestController {

    private final IReservationService reservationService;

    @PostMapping("/ajouter")
    @Operation(summary = "Ajouter une reservation")
    public Reservation ajouter(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @GetMapping("/tous")
    @Operation(summary = "Afficher toutes les reservations")
    public Set<Reservation> afficherToutes() {
        return reservationService.afficherReservations();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Afficher une reservation")
    public Reservation afficherUne(@PathVariable("id") Long id) {
        return reservationService.afficherReservation(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifier une reservation")
    public Reservation modifier(
            @PathVariable("id") Long id,
            @RequestBody Reservation reservation) {
        return reservationService.modifierReservation(id, reservation);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une reservation")
    public void supprimer(@PathVariable("id") Long id) {
        reservationService.supprimerReservation(id);
    }
}