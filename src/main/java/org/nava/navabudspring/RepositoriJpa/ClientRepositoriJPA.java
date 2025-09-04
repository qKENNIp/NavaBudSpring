package org.nava.navabudspring.RepositoriJpa;

import org.nava.navabudspring.Entity.ClientDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepositoriJPA extends JpaRepository<ClientDate,Long> {
    List<ClientDate> findByAnswerFalse();
}
