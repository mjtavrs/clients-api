package dev.marcostavares.clients_api.application.useCases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.clients_api.domain.repository.ClientRepository;
import dev.marcostavares.clients_api.interfaces.dtos.ClientResponse;

import dev.marcostavares.clients_api.domain.exceptions.NoClientsInDatabaseException;

@Service
public class ListClients {

    @Autowired
    private ClientRepository clientRepository;

    public List<ClientResponse> execute() {
        var clients = clientRepository.findAll()
                .stream()
                .map(ClientResponse::fromEntity)
                .collect(Collectors.toList());

        if (clients.isEmpty()) {
            throw new NoClientsInDatabaseException();
        }

        return clients;
    }

}
