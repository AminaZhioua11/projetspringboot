package tn.esprit.aminazhioua4actuariat.Services;

import tn.esprit.aminazhioua4actuariat.entity.Client;
import java.util.Set;

public interface IClientService {

    Client ajouterClient(Client client);

    Set<Client> afficherClients();

    Client afficherClient(Long id);

    Client modifierClient(Long id, Client client);

    void supprimerClient(Long id);
}