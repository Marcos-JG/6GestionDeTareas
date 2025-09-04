package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.crud.EstudianteCrud;
import org.algorix.gestiontareas.persistence.entity.Curso;
import org.algorix.gestiontareas.persistence.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstudianteService implements IEstudianteService{

    @Autowired
    private EstudianteCrud crud;

    @Override
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = crud.findAll();
        return estudiantes;
    }

    @Override
    public Estudiante buscarEstudiantePorId(Integer id) {
        Estudiante estudiante = crud.findById(id).orElse(null);
        return estudiante;
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        crud.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        crud.delete(estudiante);
    }
}



