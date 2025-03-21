package dev.marcostavares.clients_api.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private UUID id;

    @NotBlank(message = "The client must have a name")
    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @NotBlank(message = "The client must have a CPF")
    @Column(nullable = false, unique = true)
    @Getter
    private String CPF;

    @NotBlank(message = "The client must have an email address")
    @Email(message = "The client must have a valid email address")
    @Column(nullable = false)
    @Getter
    @Setter
    private String email;

    @NotBlank(message = "The client must have a phone number")
    @Column(nullable = false)
    @Getter
    @Setter
    private String phone;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @Getter
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    @Getter
    private LocalDateTime updatedAt;

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

}
