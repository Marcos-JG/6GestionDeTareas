package org.algorix.gestiontareas.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "cursos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tarea;
    @Column
    private String titulo;
    private String descripcion;
    private LocalDate fecha_entrega;
    private Integer id_curso;
}
