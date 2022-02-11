package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.ClientNameExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import com.andrewsavich.bajter.cartridgerefillservice.service.client.ClientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClientList() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        Client client = clientService.getClientById(clientId);

        return ResponseEntity.ok(client);
    }

    @GetMapping("/name/{clientName}")
    public ResponseEntity<Client> getClientByName(@PathVariable String clientName) {
        Client client = clientService.getClientByName(clientName);

        return ResponseEntity.ok(client);
    }

    @PostMapping
    public void createClient(@RequestBody @Valid Client client) {
        if (clientService.isExistClientName(client)) {
            throw new ClientNameExistsException("Client with name" + client.getName() + " already exist");
        }

        clientService.createClient(client);
    }

    @PutMapping
    public void updateClient(@RequestBody @Valid Client client) {
        if (clientService.isExistClientName(client)) {
            throw new ClientNameExistsException("Client with name " + client.getName() + " already exist");
        }

        clientService.updateClient(client);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClientById(clientId);
    }
}