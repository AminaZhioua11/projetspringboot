package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Equipement;
import tn.esprit.aminazhioua4actuariat.repository.EquipementRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final EquipementRepository equipementRepository;

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        equipement.setIdEquipement(null);
        equipement.setVehicule(null);
        return equipementRepository.save(equipement);
    }

    @Override
    public Set<Equipement> afficherEquipements() {
        return new HashSet<>(equipementRepository.findAll());
    }

    @Override
    public Equipement afficherEquipement(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Equipement introuvable"
                ));
    }

    @Override
    public Equipement modifierEquipement(
            Long id, Equipement equipement) {

        Equipement existant = afficherEquipement(id);
        existant.setLibelle(equipement.getLibelle());

        return equipementRepository.save(existant);
    }

    @Override
    public void supprimerEquipement(Long id) {
        Equipement equipement = afficherEquipement(id);
        equipementRepository.delete(equipement);
    }
}