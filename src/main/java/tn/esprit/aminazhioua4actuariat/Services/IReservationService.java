package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Reservation;
import java.util.Set;

public interface IReservationService {

    Reservation ajouterReservation(Reservation reservation);

    Set<Reservation> afficherReservations();

    Reservation afficherReservation(Long id);

    Reservation modifierReservation(Long id, Reservation reservation);

    void supprimerReservation(Long id);
}