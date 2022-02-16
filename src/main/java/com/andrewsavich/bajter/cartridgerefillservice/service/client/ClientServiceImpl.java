package com.andrewsavich.bajter.cartridgerefillservice.service.client;

import com.andrewsavich.bajter.cartridgerefillservice.exception.client.ClientNameExistsException;
import com.andrewsavich.bajter.cartridgerefillservice.exception.client.ClientNotFoundException;
import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import com.andrewsavich.bajter.cartridgerefillservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (Objects.isNull(client)) {
            throw new ClientNotFoundException("Client with id '" + id + "' not found");
        }

        return client;
    }

    @Override
    public Client getClientByName(String name) {
        Client client = clientRepository.findByName(name);

        if (Objects.isNull(client)) {
            throw new ClientNotFoundException("Client with name '" + name + "' not found");
        }

        return clientRepository.findByName(name);
    }

    @Override
    public Client createClient(Client client) {

        if (isExistClientName(client)) {
            throw new ClientNameExistsException("Client with name '" + client.getName() + "' exists");
        }

        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {

        if (isExistClientName(client)) {
            throw new ClientNameExistsException("Client with name '" + client.getName() + "' exists");
        }

        return clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);

        if (Objects.isNull(client)) {
            throw new ClientNotFoundException("Client with id '" + id + "' not found");
        }

        clientRepository.delete(client);
    }

    private boolean isExistClientName(Client checkingClient) {
        Client existingClient = clientRepository.findByName(checkingClient.getName());

        //case for the creating a new checkingClient without existing same name in the DB
        if (checkingClient.getId() == null) {
            return existingClient != null;
        }

        //case for the updating existing checkingClient
        if (existingClient == null) {
            return false;
        } else {
            return existingClient.getId() != checkingClient.getId();
        }
    }

}
