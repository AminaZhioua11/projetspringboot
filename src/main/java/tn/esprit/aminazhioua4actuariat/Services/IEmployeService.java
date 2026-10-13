package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Employe;
import java.util.Set;

public interface IEmployeService {

    Employe ajouterEmploye(Employe employe);

    Set<Employe> afficherEmployes();

    Employe afficherEmploye(Long id);

    Employe modifierEmploye(Long id, Employe employe);

    void supprimerEmploye(Long id);
}