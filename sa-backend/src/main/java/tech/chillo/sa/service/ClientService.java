package tech.chillo.sa.service;

import jakarta.persistence.EntityNotFoundException;
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

         //optional = can be here or not -Java-
        //if(optionalClient.isPresent() && !optionalClient.isEmpty() ){
       //     return optionalClient.get();
       // }else {//}
        //sping met a dispo des if seul ou bien avec des exception comme ca :
        //si le client et null or empty il lance la function()
             return optionalClient.orElseThrow(() -> new EntityNotFoundException("Pb de requete !!!"));
    }
    public Client lireOuCreer(Client clientAcreer){
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientDansLaBDD == null ) {
            clientDansLaBDD=  this.clientRepository.save(clientAcreer);
        }
        return clientDansLaBDD;
    }

    public void modifier(int id, Client client) {
        Client clientDansLaBDD = this.lire(id);
        if(clientDansLaBDD.getId() == client.getId()){
            clientDansLaBDD.setTelephone(client.getTelephone());
            clientDansLaBDD.setEmail(client.getEmail());
            this.clientRepository.save(clientDansLaBDD);
        }
    }
}
