package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.entity.Tarea;

import java.time.LocalDate;
import java.util.List;

public interface ITareaService {
    public List<Tarea> listarTareas();
    public Tarea buscarTareaPorId(Integer id);
    public void guardarTarea(Tarea tarea);
    public void eliminarTarea(Tarea tarea);
}
