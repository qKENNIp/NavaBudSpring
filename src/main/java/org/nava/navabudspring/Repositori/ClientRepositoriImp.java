package org.nava.navabudspring.Repositori;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoriImp implements ClientRepositori {
    private EntityManager em;

    public ClientRepositoriImp(EntityManager em) {
        this.em = em;
    }
}
