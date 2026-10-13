package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Reservation;
import tn.esprit.aminazhioua4actuariat.repository.ReservationRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        reservation.setIdReservation(null);
        reservation.setClient(null);
        reservation.setVehicule(null);
        reservation.setContrat(null);

        return reservationRepository.save(reservation);
    }

    @Override
    public Set<Reservation> afficherReservations() {
        return new HashSet<>(reservationRepository.findAll());
    }

    @Override
    public Reservation afficherReservation(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Reservation introuvable"
                ));
    }

    @Override
    public Reservation modifierReservation(
            Long id, Reservation reservation) {

        Reservation existante = afficherReservation(id);

        existante.setDateDebut(reservation.getDateDebut());
        existante.setDateFin(reservation.getDateFin());
        existante.setStatut(reservation.getStatut());

        return reservationRepository.save(existante);
    }

    @Override
    public void supprimerReservation(Long id) {
        Reservation reservation = afficherReservation(id);
        reservationRepository.delete(reservation);
    }
}