package tn.esprit.aminazhioua4actuariat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminazhioua4actuariat.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}