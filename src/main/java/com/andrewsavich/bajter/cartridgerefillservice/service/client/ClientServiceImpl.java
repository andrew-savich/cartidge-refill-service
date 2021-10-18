package com.andrewsavich.bajter.cartridgerefillservice.service.client;

import com.andrewsavich.bajter.cartridgerefillservice.model.client.Client;
import com.andrewsavich.bajter.cartridgerefillservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public boolean isExistClientName(Client checkingClient) {
        Client existingClient = clientRepository.findByName(checkingClient.getName());

        //case for the creating a new checkingClient without existing same name in the DB
        if(checkingClient.getId() == null){
            return existingClient != null;
        }

        //case for the updating existing checkingClient
        if(existingClient == null){
            return false;
        } else {
            return existingClient.getId() != checkingClient.getId();
        }
    }
}
