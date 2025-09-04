package org.algorix.gestiontareas.persistence.crud;

import org.algorix.gestiontareas.persistence.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareasCrud extends JpaRepository<Tarea,Integer> {
}
