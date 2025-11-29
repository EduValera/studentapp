package com.certus.studentapp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombres;
    private String apellidos;

    private String email;

    @ManyToMany
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    private List<Curso> cursos;

    public Estudiante() {}

    // ID
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    // NOMBRES
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    // APELLIDOS
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    // EMAIL
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // CURSOS
    public List<Curso> getCursos() { return cursos; }
    public void setCursos(List<Curso> cursos) { this.cursos = cursos; }
}
