package com.certus.studentapp.controller;

import com.certus.studentapp.model.Estudiante;
import com.certus.studentapp.repository.CursoRepository;
import com.certus.studentapp.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;
    private final CursoRepository cursoRepository;

    public EstudianteController(EstudianteService estudianteService, CursoRepository cursoRepository) {
        this.estudianteService = estudianteService;
        this.cursoRepository = cursoRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarTodos());
        return "list";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("cursos", cursoRepository.findAll());
        return "create";
    }

    @PostMapping("/guardar")
    public String guardar(Estudiante estudiante) {
        estudianteService.guardar(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("estudiante", estudianteService.obtenerPorId(id));
        model.addAttribute("cursos", cursoRepository.findAll());
        return "edit";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        estudianteService.eliminar(id);
        return "redirect:/estudiantes";
    }
}
