package org.algorix.gestiontareas.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "entregas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrega;
    @Column
    private LocalDate fecha_entrega;
    private String calificacion;
    private Integer id_tarea;
    private Integer id_estudiante;
}
