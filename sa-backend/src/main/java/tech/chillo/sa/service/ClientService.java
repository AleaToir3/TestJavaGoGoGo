package tech.chillo.sa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        this.clientRepository.save(client);
    }
    public List<Client>recherche(){
        return this.clientRepository.findAll();
    }
}
