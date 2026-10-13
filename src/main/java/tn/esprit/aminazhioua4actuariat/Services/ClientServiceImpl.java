package tn.esprit.aminazhioua4actuariat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.aminazhioua4actuariat.entity.Client;
import tn.esprit.aminazhioua4actuariat.repository.ClientRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final ClientRepository clientRepository;

    @Override
    public Client ajouterClient(Client client) {
        client.setIdClient(null);
        return clientRepository.save(client);
    }

    @Override
    public Set<Client> afficherClients() {
        return new HashSet<>(clientRepository.findAll());
    }

    @Override
    public Client afficherClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Client introuvable"
                ));
    }

    @Override
    public Client modifierClient(Long id, Client client) {
        Client existant = afficherClient(id);

        existant.setNom(client.getNom());
        existant.setPrenom(client.getPrenom());
        existant.setEmail(client.getEmail());
        existant.setTelephone(client.getTelephone());
        existant.setNumPermis(client.getNumPermis());
        existant.setDateInscription(client.getDateInscription());

        return clientRepository.save(existant);
    }

    @Override
    public void supprimerClient(Long id) {
        Client client = afficherClient(id);
        clientRepository.delete(client);
    }
}