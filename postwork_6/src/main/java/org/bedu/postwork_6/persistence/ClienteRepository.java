package org.bedu.postwork_6.persistence;

import org.bedu.postwork_6.persistence.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
