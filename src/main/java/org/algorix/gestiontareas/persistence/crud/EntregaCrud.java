package org.algorix.gestiontareas.persistence.crud;

import org.algorix.gestiontareas.persistence.entity.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaCrud extends JpaRepository<Entrega,Integer> {
}
