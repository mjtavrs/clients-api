package dev.marcostavares.clients_api.application.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.clients_api.domain.model.Client;
import dev.marcostavares.clients_api.domain.repository.ClientRepository;

@Service
public class CreateClient {

    @Autowired
    private ClientRepository clientRepository;

    public Client execute(Client clientToBeCreated) {
        this.clientRepository
                .findByCPF(clientToBeCreated.getCPF())
                .ifPresent(client -> {
                    throw new IllegalArgumentException("CPF already registered");
                });

        return this.clientRepository.save(clientToBeCreated);
    }

}
