package dev.marcostavares.clients_api.interfaces.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcostavares.clients_api.application.useCases.CreateClient;
import dev.marcostavares.clients_api.domain.model.Client;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private CreateClient createClient;

    @PostMapping
    public ResponseEntity<Object> createClient(@Valid @RequestBody Client client) {
        var result = this.createClient.execute(client);
        return ResponseEntity.ok().body(result);
    }
}
