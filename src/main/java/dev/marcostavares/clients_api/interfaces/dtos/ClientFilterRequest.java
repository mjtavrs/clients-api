package dev.marcostavares.clients_api.interfaces.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientFilterRequest {

    private String name;
    private String email;
    private String phone;
}
