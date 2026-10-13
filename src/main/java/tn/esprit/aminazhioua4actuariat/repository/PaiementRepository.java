package tn.esprit.aminazhioua4actuariat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminazhioua4actuariat.entity.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}