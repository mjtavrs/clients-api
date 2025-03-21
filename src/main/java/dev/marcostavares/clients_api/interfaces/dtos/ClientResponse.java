package dev.marcostavares.clients_api.interfaces.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import dev.marcostavares.clients_api.domain.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ClientResponse fromEntity(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .phone(client.getPhone())
                .createdAt(client.getCreatedAt())
                .updatedAt(client.getUpdatedAt())
                .build();
    }

}
