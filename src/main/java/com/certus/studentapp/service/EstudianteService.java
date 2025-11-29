package com.certus.studentapp.service;

import com.certus.studentapp.model.Estudiante;
import java.util.List;

public interface EstudianteService {
    List<Estudiante> listarTodos();
    Estudiante obtenerPorId(Integer id);
    Estudiante guardar(Estudiante estudiante);
    void eliminar(Integer id);
}
