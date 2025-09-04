package org.algorix.gestiontareas.persistence.crud;

import org.algorix.gestiontareas.persistence.entity.EstudianteCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteCursoCrud extends JpaRepository<EstudianteCurso,Integer> {
}
