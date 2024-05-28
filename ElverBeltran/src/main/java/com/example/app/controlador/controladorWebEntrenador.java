package com.example.app.controlador;

import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.app.variables.*;
import com.example.app.crud.*;

@Controller
public class controladorWebEntrenador {

    @Autowired
    private crudEntrenador entrenadorRepositorio;

    @GetMapping("/verEntrenador")
    public String listarEntrenador(Model model) {
        List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);
        return "verEntrenador";
    }

    @GetMapping("/verEntrenador/formEntrenador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "formEntrenador";
    }

    @PostMapping("/guardarEntrenador")
    public String guardarEntrenador(Entrenador entrenador) {
        entrenadorRepositorio.save(entrenador);
        return "redirect:/verEntrenador";
    }

    @GetMapping("/entrenador/editar/{id}")
    public String modificarEntrenador(@PathVariable("id") Long id, Model model) {
        Entrenador entrenador = entrenadorRepositorio.findById(id).get();
        model.addAttribute("entrenador", entrenador);
        return "formEntrenador";
    }

    @GetMapping("/entrenador/eliminar/{id}")
    public String eliminarEntrenador(@PathVariable("id") Long id, Model model) {
        entrenadorRepositorio.deleteById(id);
        return "redirect:/verEntrenador";
    }
}

