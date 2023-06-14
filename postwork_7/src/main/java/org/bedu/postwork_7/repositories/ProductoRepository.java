package org.bedu.postwork_7.repositories;

import org.bedu.postwork_7.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
