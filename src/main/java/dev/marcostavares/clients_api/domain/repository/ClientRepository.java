package dev.marcostavares.clients_api.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcostavares.clients_api.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, UUID> {

}
