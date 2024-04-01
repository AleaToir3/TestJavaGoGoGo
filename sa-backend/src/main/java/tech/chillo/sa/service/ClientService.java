package tech.chillo.sa.service;

import org.springframework.stereotype.Service;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLaBDD == null ) {
            this.clientRepository.save(client);
        }
    }
    public List<Client>recherche(){
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
         Optional<Client> optionalClient =this.clientRepository.findById(id);
        if(optionalClient.isPresent() && !optionalClient.isEmpty() ){
            return optionalClient.get();
        }else {
             return null;
        }
    }
    public Client lireOuCreer(Client clientAcreer){
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientDansLaBDD == null ) {
            clientDansLaBDD=  this.clientRepository.save(clientAcreer);
        }
        return clientDansLaBDD;
    }
}
