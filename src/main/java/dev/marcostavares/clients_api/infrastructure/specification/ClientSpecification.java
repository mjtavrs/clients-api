package dev.marcostavares.clients_api.infrastructure.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import dev.marcostavares.clients_api.domain.model.Client;
import dev.marcostavares.clients_api.interfaces.dtos.ClientFilterRequest;
import jakarta.persistence.criteria.Predicate;

public class ClientSpecification {

    public static Specification<Client> withFilters(ClientFilterRequest filter) {
        System.out
                .println("Filtro recebido: " + filter.getName() + ", " + filter.getEmail() + ", " + filter.getPhone());
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getName() != null && !filter.getName().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
            }

            if (filter.getEmail() != null && !filter.getEmail().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("email")), "%" + filter.getEmail().toLowerCase() + "%"));
            }

            if (filter.getPhone() != null && !filter.getPhone().isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("phone")), "%" + filter.getPhone().toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
