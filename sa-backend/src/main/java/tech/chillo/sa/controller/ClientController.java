package tech.chillo.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.service.ClientService;
import org.springframework.http.MediaType;


import java.util.List;


@RestController
@RequestMapping(path = "client")
public class ClientController  {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    //il a  que le GET qui a un body donc je le transforme seulement pour le post
    public void creer(@RequestBody Client client) {
        this.clientService.creer(client);
    }
    @GetMapping(produces = "application/json")
    public List<Client>rechercher(){
        return this.clientService.recherche();
    }

}
