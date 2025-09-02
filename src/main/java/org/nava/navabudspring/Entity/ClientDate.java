package org.nava.navabudspring.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ClientDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String clientId;
    private String name;
    private String surname;
    private String email;
    private String phone;

    public ClientDate() {}
}
