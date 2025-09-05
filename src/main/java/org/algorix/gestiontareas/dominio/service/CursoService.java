package org.algorix.gestiontareas.dominio.service;

import org.algorix.gestiontareas.persistence.crud.CursoCrud;
import org.algorix.gestiontareas.persistence.entity.Curso;
import org.algorix.gestiontareas.persistence.entity.Profesor;
import org.algorix.gestiontareas.dominio.service.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private CursoCrud crud;
    @Autowired
    private IProfesorService profesorService;


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

    @Override
    public Profesor obtenerProfesorDelCurso(Integer idCurso) {
        // Obtener todos los cursos y profesores y verificar asociación por id
        List<Curso> cursos = crud.findAll();
        List<Profesor> profesores = profesorService.listarProfesores();

        Curso cursoBuscado = null;
        for (Curso c : cursos) {
            if (c.getId_curso() != null && c.getId_curso().equals(idCurso)) {
                cursoBuscado = c;
                break;
            }
        }
        if (cursoBuscado == null || cursoBuscado.getId_profesor() == null) {
            return null;
        }

        Integer idProfesor = cursoBuscado.getId_profesor();
        for (Profesor p : profesores) {
            if (p.getId_profesor() != null && p.getId_profesor().equals(idProfesor)) {
                return p;
            }
        }
        return null;
    }

}
