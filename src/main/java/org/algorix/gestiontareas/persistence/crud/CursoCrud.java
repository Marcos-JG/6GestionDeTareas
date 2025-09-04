package org.algorix.gestiontareas.persistence.crud;

import org.algorix.gestiontareas.persistence.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoCrud extends JpaRepository<Curso,Integer> {
}
