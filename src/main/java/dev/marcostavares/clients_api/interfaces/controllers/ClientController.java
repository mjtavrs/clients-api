package dev.marcostavares.clients_api.interfaces.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcostavares.clients_api.application.useCases.CreateClient;
import dev.marcostavares.clients_api.application.useCases.DeleteClient;
import dev.marcostavares.clients_api.application.useCases.ListClients;
import dev.marcostavares.clients_api.application.useCases.UpdateClient;
import dev.marcostavares.clients_api.domain.model.Client;
import dev.marcostavares.clients_api.interfaces.dtos.ClientFilterRequest;
import dev.marcostavares.clients_api.interfaces.dtos.ClientResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private CreateClient createClient;

    @Autowired
    private ListClients listClients;

    @Autowired
    private UpdateClient updateClient;

    @Autowired
    private DeleteClient deleteClient;

    @PostMapping
    public ResponseEntity<Object> createClient(@Valid @RequestBody Client client) {
        var result = this.createClient.execute(client);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients(@ModelAttribute ClientFilterRequest filter) {
        var clients = listClients.execute(filter);
        return ResponseEntity.ok().body(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable UUID id, @Valid @RequestBody Client client) {
        ClientResponse clientToUpdate = updateClient.execute(id, client);
        return ResponseEntity.ok(clientToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable UUID id) {
        return deleteClient.execute(id);
    }

}
