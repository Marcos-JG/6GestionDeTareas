package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.crud.CursoCrud;
import org.algorix.gestiontareas.persistence.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoCrud crud;


    @Override
    public List<Curso> listarCursos() {
        List<Curso> cursos = crud.findAll();
        return cursos;
    }

    @Override
    public Curso buscarCursoPorId(Integer id) {
        Curso curso = crud.findById(id).orElse(null);
        return curso;
    }

    @Override
    public void guardarCurso(Curso curso) {
        crud.save(curso);
    }

    @Override
    public void eliminarCurso(Curso curso) {
        crud.delete(curso);
    }
}
