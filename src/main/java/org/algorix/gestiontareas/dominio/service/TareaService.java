package org.algorix.gestiontareas.dominio.service;


import org.algorix.gestiontareas.persistence.crud.TareasCrud;
import org.algorix.gestiontareas.persistence.entity.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TareaService implements ITareaService {

    @Autowired
    private TareasCrud crud;


    @Override
    public List<Tarea> listarTareas() {
        List<Tarea> Tareas = crud.findAll();
        return Tareas;
    }

    @Override
    public Tarea buscarTareaPorId(Integer id) {
        Tarea tareas = crud.findById(id).orElse(null);
        return tareas;
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        crud.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea) {
        crud.delete(tarea);
    }

}
