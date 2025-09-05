package org.algorix.gestiontareas.persistence.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "profesores")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_profesor;
    @Column
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
}
