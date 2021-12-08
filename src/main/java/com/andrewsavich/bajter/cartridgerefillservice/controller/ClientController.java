package com.andrewsavich.bajter.cartridgerefillservice.controller;

import com.andrewsavich.bajter.cartridgerefillservice.exception.ClientNameExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import com.andrewsavich.bajter.cartridgerefillservice.service.client.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(value = "/api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Operation(summary = "Returning client list")
    @ApiResponse(responseCode = "200", description = "Clients were found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping
    public List<Client> getClientList(){
        log.info("Controller: getting client list");

        return clientService.getAllClients();
    }

    @Operation(summary = "Returning client by id")
    @ApiResponse(responseCode = "200", description = "Client was found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId){
        log.info("Controller: getting client with id: " + clientId);
        Client client = clientService.getClientById(clientId);

        log.info("Controller: sending client with id: " + clientId);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Returning client by name")
    @ApiResponse(responseCode = "200", description = "Client was found", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/name/{clientName}")
    public ResponseEntity<Client> getClientByName(@PathVariable String clientName){
        log.info("Controller: getting client with name: " + clientName);
        Client client = clientService.getClientByName(clientName);

        log.info("Controller: sending client with name: " + clientName);
        return ResponseEntity.ok(client);
    }

    @Operation(summary = "Creating a new client")
    @ApiResponse(responseCode = "200", description = "Client was created", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PostMapping
    public void createClient(@RequestBody @Valid Client client){
        log.info("Controller: Got client for creating: " + client);

        if(clientService.isExistClientName(client)){
            throw new ClientNameExistsException("Client with name" + client.getName() + " already exist");
        }

        clientService.createClient(client);
    }

    @Operation(summary = "Updating client")
    @ApiResponse(responseCode = "200", description = "Client was updated", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PutMapping
    public void updateClient(@RequestBody @Valid Client client){
        log.info("Controller: Got client for updating: " + client);

        if(clientService.isExistClientName(client)){
            throw new ClientNameExistsException("Client with name " + client.getName() + " already exist");
        }

        clientService.updateClient(client);
    }

    @Operation(summary = "Deleting client by id")
    @ApiResponse(responseCode = "200", description = "Client was deleted", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId){
        log.info("Controller: Deleting client with id: " + clientId);

        clientService.deleteClientById(clientId);
    }
}