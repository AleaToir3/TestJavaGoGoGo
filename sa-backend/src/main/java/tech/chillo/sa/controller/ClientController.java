package tech.chillo.sa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.chillo.sa.entites.Client;


@RestController
@RequestMapping(path = "client")
public class ClientController  {
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    //il a  que le GET qui a un body donc je le transforme seulement pour le post
    public void creer(@RequestBody Client client) {

    }
}
