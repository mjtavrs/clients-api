package dev.marcostavares.clients_api.application.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.clients_api.domain.exceptions.ClientNotFoundException;
import dev.marcostavares.clients_api.domain.model.Client;
import dev.marcostavares.clients_api.domain.repository.ClientRepository;
import dev.marcostavares.clients_api.interfaces.dtos.ClientResponse;

@Service
public class UpdateClient {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse execute(UUID id, Client clientToBeUpdated) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(clientToBeUpdated.getName());
                    client.setEmail(clientToBeUpdated.getEmail());
                    client.setPhone(clientToBeUpdated.getPhone());
                    return ClientResponse.fromEntity(clientRepository.save(client));
                }).orElseThrow(ClientNotFoundException::new);
    }

}
