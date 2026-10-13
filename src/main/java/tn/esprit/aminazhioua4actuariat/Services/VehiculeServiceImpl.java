package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Vehicule;
import tn.esprit.aminazhioua4actuariat.repository.VehiculeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        vehicule.setIdVehicule(null);
        vehicule.setAgence(null);
        vehicule.setMaintenances(new HashSet<>());
        vehicule.setEquipements(new HashSet<>());
        vehicule.setReservations(new HashSet<>());

        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Set<Vehicule> afficherVehicules() {
        return new HashSet<>(vehiculeRepository.findAll());
    }

    @Override
    public Vehicule afficherVehicule(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Vehicule introuvable"
                ));
    }

    @Override
    public Vehicule modifierVehicule(Long id, Vehicule vehicule) {
        Vehicule existant = afficherVehicule(id);

        existant.setImmatriculation(vehicule.getImmatriculation());
        existant.setMarque(vehicule.getMarque());
        existant.setModele(vehicule.getModele());
        existant.setCategorie(vehicule.getCategorie());
        existant.setTarifJournalier(vehicule.getTarifJournalier());
        existant.setStatut(vehicule.getStatut());

        return vehiculeRepository.save(existant);
    }

    @Override
    public void supprimerVehicule(Long id) {
        Vehicule vehicule = afficherVehicule(id);
        vehiculeRepository.delete(vehicule);
    }
}