package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.entity.Estudiante;

import java.util.List;

public interface IEstudianteService {
    List<Estudiante> listarEstudiantes();
    Estudiante buscarEstudiantePorId(Integer id);
    void guardarEstudiante(Estudiante estudiante);
    void eliminarEstudiante(Estudiante estudiante);
}
