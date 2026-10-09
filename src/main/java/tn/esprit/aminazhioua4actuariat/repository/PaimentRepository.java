package tn.esprit.aminazhioua4actuariat.repository;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aminazhioua4actuariat.entity.Paiement;

public interface PaimentRepository extends JpaRepository<Paiement,Long> {
}
