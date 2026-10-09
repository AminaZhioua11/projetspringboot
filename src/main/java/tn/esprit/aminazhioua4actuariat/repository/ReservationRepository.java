package tn.esprit.aminazhioua4actuariat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminazhioua4actuariat.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation ,Long> {
}
