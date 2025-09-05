package org.algorix.gestiontareas.web.controller;


import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.algorix.gestiontareas.dominio.service.ICursoService;
import org.algorix.gestiontareas.persistence.entity.Curso;
import org.algorix.gestiontareas.persistence.entity.Profesor;
import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@ViewScoped
public class CursoController {
    @Autowired
    ICursoService cursoService;
    private List<Curso> cursos;
    private Curso cursoselecionado;
    private Profesor profesorDelCurso;
    private String materiaSeleccionada;
    private static final Logger logger = LoggerFactory.getLogger(CursoController.class);
    Logger looger = LoggerFactory.getLogger(CursoController.class);

    @PostConstruct
    public void init() {
        cargarDatos();
    }

    public void cargarDatos() {
        this.cursos = this.cursoService.listarCursos();
        this.cursos.forEach(curso -> logger.info(curso.toString()));

    }

    // Devuelve la lista filtrada por la materia seleccionada (si aplica)
    public List<Curso> getCursosFiltrados() {
        if (this.materiaSeleccionada == null || this.materiaSeleccionada.isEmpty()) {
            return this.cursos != null ? this.cursos : new ArrayList<>();
        }
        List<Curso> filtrados = new ArrayList<>();
        if (this.cursos != null) {
            for (Curso c : this.cursos) {
                if (c.getNombre() != null && c.getNombre().equals(this.materiaSeleccionada)) {
                    filtrados.add(c);
                }
            }
        }
        return filtrados;
    }

    // Método llamado desde la vista para marcar un curso como seleccionado
    public void seleccionarCurso(Curso curso) {
        this.cursoselecionado = curso;
    }

    public void agregarCurso() {
        this.cursoselecionado = new Curso();
    }

    public void guardarCurso(){
        looger.info("Curso a guardar: "+this.cursoselecionado);
        if(this.cursoselecionado.getId_curso()==null){
            this.cursoService.guardarCurso(this.cursoselecionado);
            this.cursos.add(this.cursoselecionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso Agregado"));
        }else {
            this.cursoService.guardarCurso(this.cursoselecionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Curso Modificado"));
        }
        PrimeFaces.current().executeScript("PF('ventanaModalCurso').hide()");
        PrimeFaces.current().ajax().update("formulario-curso:mensaje_emergente","formulario-curso:tabla-cursos");
        this.cursoselecionado = null;
    }

    public void mostrarProfesorDelCurso(){
        if (this.cursoselecionado == null || this.cursoselecionado.getId_curso() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No hay curso seleccionado"));
            return;
        }
        Profesor p = this.cursoService.obtenerProfesorDelCurso(this.cursoselecionado.getId_curso());
        this.profesorDelCurso = p;
        if (p == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Profesor no encontrado para el curso"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Profesor: " + p.getNombre()));
        }
        PrimeFaces.current().ajax().update("formulario-curso:mensaje_emergente");
    }
}
