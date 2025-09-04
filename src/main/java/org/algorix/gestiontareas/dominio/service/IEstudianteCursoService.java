package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.entity.EstudianteCurso;

import java.util.List;

public interface IEstudianteCursoService {
    List<EstudianteCurso> listarEstudiantesCurso();
    EstudianteCurso buscarEstudiantePorId(Integer id);
    void guardarEstudianteCurso(EstudianteCurso estudianteCurso);
    void eliminarEstudianteCurso(EstudianteCurso estudianteCurso);
}
