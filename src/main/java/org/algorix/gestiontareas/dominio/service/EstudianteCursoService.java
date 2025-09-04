package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.crud.EstudianteCursoCrud;
import org.algorix.gestiontareas.persistence.entity.EstudianteCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteCursoService implements IEstudianteCursoService {

    @Autowired
    private EstudianteCursoCrud crud;

    @Override
    public List<EstudianteCurso> listarEstudiantesCurso() {
        List<EstudianteCurso> estudiantesCurso = crud.findAll();
        return estudiantesCurso;
    }

    @Override
    public EstudianteCurso buscarEstudiantePorId(Integer id) {
        EstudianteCurso estudianteCurso = crud.findById(id).orElse(null);
        return estudianteCurso;
    }

    @Override
    public void guardarEstudianteCurso(EstudianteCurso estudianteCurso) {
        crud.save(estudianteCurso);
    }

    @Override
    public void eliminarEstudianteCurso(EstudianteCurso estudianteCurso) {
        crud.delete(estudianteCurso);
    }
}
