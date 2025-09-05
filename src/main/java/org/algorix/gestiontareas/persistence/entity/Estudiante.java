package org.algorix.gestiontareas.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_estudiante;
    @Column
    private String nombre;
    private String correo;
    @Column(name = "contraseña")
    private String contraseña;
}
