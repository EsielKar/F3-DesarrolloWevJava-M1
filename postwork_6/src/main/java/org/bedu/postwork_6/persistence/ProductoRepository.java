package org.bedu.postwork_6.persistence;

import org.bedu.postwork_6.persistence.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
