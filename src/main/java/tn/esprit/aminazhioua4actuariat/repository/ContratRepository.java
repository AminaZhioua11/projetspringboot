package tn.esprit.aminazhioua4actuariat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import tn.esprit.aminazhioua4actuariat.entity.Contrat;

public interface ContratRepository extends JpaRepository<Contrat , Long>
{
}
