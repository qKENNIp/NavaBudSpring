package org.nava.navabudspring.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class ClientDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long clientId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String surname;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 12)
    private String phone;

    @Column(nullable = false)
    private Boolean answer = false;

    public ClientDate() {}

    @Override
    public String toString() {
        return
                "name: " + name + " " + surname + "\n" +
                "email: " + email + "\n" +
                "phone: " + phone + "\n"
                ;
    }
}
