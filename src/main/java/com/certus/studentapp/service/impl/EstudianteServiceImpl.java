package com.certus.studentapp.service.impl;

import com.certus.studentapp.model.Estudiante;
import com.certus.studentapp.repository.EstudianteRepository;
import com.certus.studentapp.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository repo;

    public EstudianteServiceImpl(EstudianteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Estudiante> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Estudiante obtenerPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Estudiante guardar(Estudiante estudiante) {
        return repo.save(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
