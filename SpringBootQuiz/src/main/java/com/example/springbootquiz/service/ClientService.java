package com.example.springbootquiz.service;

import com.example.springbootquiz.data.ClientRepo;
import com.example.springbootquiz.models.Client;
import com.example.springbootquiz.models.Product;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    private ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> getListOfClients() {
        List<Client> clients = new ArrayList<>();
        clientRepo.findAll().forEach(clients::add);
        return clients;
    }
    public void saveClient(Client client) {
        clientRepo.save(client);
    }
    public void editClient(Client client) {
        Client existingClientDetails = clientRepo.findById(client.getId()).orElseThrow(
                () -> new ResourceNotFoundException("product Not Found"));
        if (client.getClientName() != null){
            existingClientDetails.setClientName(client.getClientName());
        }
        if (client.getClientLastName()!= null){
            existingClientDetails.setClientLastName(client.getClientLastName());
        }
        if (client.getClientMobile()!= null){
            existingClientDetails.setClientMobile(client.getClientMobile());
        }

        clientRepo.save(existingClientDetails);
    }
}
