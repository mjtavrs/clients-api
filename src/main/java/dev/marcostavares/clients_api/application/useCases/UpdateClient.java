package dev.marcostavares.clients_api.application.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.clients_api.domain.exceptions.ClientNotFoundException;
import dev.marcostavares.clients_api.domain.repository.ClientRepository;
import dev.marcostavares.clients_api.interfaces.dtos.ClientResponse;
import dev.marcostavares.clients_api.interfaces.dtos.ClientUpdateRequest;

@Service
public class UpdateClient {

    @Autowired
    private ClientRepository clientRepository;

    public ClientResponse execute(UUID id, ClientUpdateRequest request) {
        return clientRepository.findById(id)
                .map(client -> {
                    if (request.getName() != null && !request.getName().isBlank()) {
                        client.setName(request.getName());
                    }

                    if (request.getEmail() != null && !request.getEmail().isBlank()) {
                        client.setEmail(request.getEmail());
                    }

                    if (request.getPhone() != null && !request.getPhone().isBlank()) {
                        client.setPhone(request.getPhone());
                    }

                    return ClientResponse.fromEntity(clientRepository.save(client));
                }).orElseThrow(ClientNotFoundException::new);
    }

}
