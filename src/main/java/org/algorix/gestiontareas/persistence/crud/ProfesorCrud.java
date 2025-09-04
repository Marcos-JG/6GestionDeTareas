package org.algorix.gestiontareas.persistence.crud;
import org.algorix.gestiontareas.persistence.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorCrud extends JpaRepository<Profesor,Integer> {
}
