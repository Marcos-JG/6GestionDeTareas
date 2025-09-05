package org.algorix.gestiontareas.web.controller;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.algorix.gestiontareas.dominio.service.IEstudianteService;
import org.algorix.gestiontareas.dominio.service.IProfesorService;
import org.algorix.gestiontareas.persistence.entity.Estudiante;
import org.algorix.gestiontareas.persistence.entity.Profesor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexController {

    @Autowired
    IEstudianteService estudianteService;
    private List<Estudiante> estudiantes;
    private Estudiante estudianteSeleccionado;

    @Autowired
    IProfesorService profesorService;
    private List<Profesor> profesores;
    private  Profesor profesorSeleccionado;

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    public void cargarDatos(){
        this.estudiantes = this.estudianteService.listarEstudiantes();
        this.estudiantes.forEach(estudiante -> logger.info(estudiante.toString()));

        this.profesores = this.profesorService.listarProfesores();
        this.profesores.forEach(profesor -> logger.info(profesor.toString()));
    }

    @PostConstruct
    public void init() {
        cargarDatos();
    }


}
