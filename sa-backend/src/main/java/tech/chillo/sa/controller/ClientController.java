package tech.chillo.sa.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.chillo.sa.dto.ErrorEntity;
import tech.chillo.sa.entites.Client;
import tech.chillo.sa.service.ClientService;
import org.springframework.http.MediaType;


import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestController
@RequestMapping(path = "client")
public class ClientController  {
    private ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void creer(@RequestBody Client client) {
        this.clientService.creer(client);
    }
    @GetMapping(produces = "application/json")
    public List<Client>rechercher(){
        return this.clientService.recherche();
    }
    @GetMapping(path = "{id}",produces = "application/json")
    public ResponseEntity lire(@PathVariable int id){
        try {
        Client client =  this.clientService.lire(id);
        return ResponseEntity.ok(client);
            }catch (EntityNotFoundException exception){
                return  ResponseEntity.status(BAD_REQUEST).body(new ErrorEntity(null, exception.getMessage()));
            }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}",consumes = "application/json")
    public void modifier(@PathVariable int id,@RequestBody Client client){
        this.clientService.modifier(id,client);
    }

}
