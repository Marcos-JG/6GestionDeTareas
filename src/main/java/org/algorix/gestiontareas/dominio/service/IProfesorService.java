package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.entity.Profesor;

import java.util.List;

public interface IProfesorService {
    List<Profesor> listarProfesores();
    Profesor buscarProfesor(Integer id);
    void guardarProfesor(Profesor profesor);
    void eliminarProfesor(Profesor profesor);
}
