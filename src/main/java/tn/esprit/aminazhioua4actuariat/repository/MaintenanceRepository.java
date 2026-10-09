package tn.esprit.aminazhioua4actuariat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminazhioua4actuariat.entity.Equipement;

public interface MaintenanceRepository extends JpaRepository<Equipement,Long> {
}
