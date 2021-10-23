package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.ClientNameExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import com.andrewsavich.bajter.cartridgerefillservice.service.client.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClientList(){
        return clientService.getAllClients();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        Client client = clientService.getClientById(id);

        return ResponseEntity.ok(client);
    }

    @PostMapping("/create")
    public void createClient(@RequestBody Client client){

        if(clientService.isExistClientName(client)){
            throw new ClientNameExistsException("Client with name" + client.getName() + " already exist");
        }

        clientService.saveClient(client);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client changedClient, @PathVariable Long id){
        Client client = clientService.getClientById(id);
        clientService.updateFields(client, changedClient);

        if(clientService.isExistClientName(client)){
            throw new ClientNameExistsException("Client with name " + client.getName() + " already exist");
        }

        Client updatedClient = clientService.saveClient(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id){
        Client client = clientService.getClientById(id);
        clientService.deleteClient(client);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", true);

        return ResponseEntity.ok(response);
    }
}