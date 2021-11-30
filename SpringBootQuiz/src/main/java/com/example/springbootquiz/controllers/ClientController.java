package com.example.springbootquiz.controllers;

import com.example.springbootquiz.models.Client;
import com.example.springbootquiz.models.Product;
import com.example.springbootquiz.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    public ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @GetMapping(path = "/api/v1/clients")
    List<Client> getClients()  {
        return clientService.getListOfClients();
    }
    @PostMapping(path = "api/v1/add_client")
    void addNewClient(@RequestBody(required = true) Client client) {
        clientService.saveClient(client);
    }
    @PostMapping(path = "api/v1/edit_client")
    void editExistClient(@RequestBody(required = true) Client client) {
        clientService.editClient(client);
    }
}
