package org.bedu.postwork_7.repositories;

import org.bedu.postwork_7.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
