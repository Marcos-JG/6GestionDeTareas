package org.algorix.gestiontareas.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_curso;
    @Column
    private String nombre;
    private String descripcion;
    private Integer id_profesor;
}
