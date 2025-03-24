package dev.marcostavares.clients_api.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoClientsInDatabaseException extends RuntimeException {
    public NoClientsInDatabaseException() {
        super("No clients found in the database.");
    }
}
