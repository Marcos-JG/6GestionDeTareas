package org.algorix.gestiontareas.persistence.crud;
import org.algorix.gestiontareas.persistence.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCrud extends JpaRepository<Estudiante,Integer> {
}
