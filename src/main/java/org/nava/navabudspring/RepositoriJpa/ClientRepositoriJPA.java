package org.nava.navabudspring.RepositoriJpa;

import org.nava.navabudspring.Entity.ClientDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepositoriJPA extends JpaRepository<ClientDate,Long> {
}
