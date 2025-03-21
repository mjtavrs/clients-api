package dev.marcostavares.clients_api.application.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.marcostavares.clients_api.domain.exceptions.ClientNotFoundException;
import dev.marcostavares.clients_api.domain.repository.ClientRepository;

@Service
public class DeleteClient {

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<String> execute(UUID id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        }

        clientRepository.deleteById(id);
        return ResponseEntity.ok().body("Client successfully deleted.");
    }

}
