package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.entity.Curso;

import java.util.List;

public interface ICursoService {
    List<Curso> listarCursos();
    Curso buscarCursoPorId(Integer id);
    void guardarCurso(Curso curso);
    void eliminarCurso(Curso curso);
}
