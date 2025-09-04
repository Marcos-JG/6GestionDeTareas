package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.crud.ProfesorCrud;
import org.algorix.gestiontareas.persistence.entity.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfersorService implements IProfesorService {

    @Autowired
    private ProfesorCrud crud;

    @Override
    public List<Profesor> listarProfesores() {
        List<Profesor> profesores = crud.findAll();
        return profesores;
    }

    @Override
    public Profesor buscarProfesor(Integer id) {
        Profesor profesor = crud.findById(id).orElse(null);
        return profesor;
    }

    @Override
    public void guardarProfesor(Profesor profesor) {
        crud.save(profesor);
    }

    @Override
    public void eliminarProfesor(Profesor profesor) {
        crud.delete(profesor);
    }
}
