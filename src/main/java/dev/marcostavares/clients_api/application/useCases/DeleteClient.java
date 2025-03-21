package dev.marcostavares.clients_api.application.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.clients_api.domain.repository.ClientRepository;

@Service
public class DeleteClient {

    @Autowired
    private ClientRepository clientRepository;

    public void execute(UUID id) {
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException("Client not found.");
        }

        clientRepository.deleteById(id);
    }

}
