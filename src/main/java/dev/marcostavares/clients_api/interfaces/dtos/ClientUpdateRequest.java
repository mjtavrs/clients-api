package dev.marcostavares.clients_api.interfaces.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientUpdateRequest {
    private String name;
    private String email;
    private String phone;
}
