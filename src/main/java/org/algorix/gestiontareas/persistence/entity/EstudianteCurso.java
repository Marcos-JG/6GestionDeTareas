package org.algorix.gestiontareas.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "estudiantes_cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EstudianteCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estudiante_curso;
    @Column
    private Integer id_curso;
    private Integer id_estudiante;
}
