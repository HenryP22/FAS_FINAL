package pe.edu.upc.cliente.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String nombre;

    @Column(length = 40, nullable = false)
    private String descripcion;

    @Column(length = 40, nullable = false)
    private Long calificacion;

    @Column(name = "fecha_publicacion",length = 40, nullable = false)
    private String fechaPublicacion;

}
