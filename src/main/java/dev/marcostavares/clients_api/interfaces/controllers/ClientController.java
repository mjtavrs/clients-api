package dev.marcostavares.clients_api.interfaces.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcostavares.clients_api.application.useCases.CreateClient;
import dev.marcostavares.clients_api.application.useCases.ListClients;
import dev.marcostavares.clients_api.domain.model.Client;
import dev.marcostavares.clients_api.interfaces.dtos.ClientResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private CreateClient createClient;

    @Autowired
    private ListClients listClients;

    @PostMapping
    public ResponseEntity<Object> createClient(@Valid @RequestBody Client client) {
        var result = this.createClient.execute(client);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        var clients = listClients.execute();
        return ResponseEntity.ok().body(clients);
    }
}
