package com.example.app.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.app.variables.*;
import com.example.app.crud.*;


@Controller
public class controladorWebClub {

    @Autowired
    private CrudClub clubRepositorio;

    @Autowired
    private crudEntrenador entrenadorRepositorio;

    @Autowired
    private crudAsociacion asociacionRepositorio;

    @Autowired
    private crudCompeticion competicionRepositorio;

    @GetMapping("/verClub")
    public String listarClub(Model model) {
        List<club> listaClub = clubRepositorio.findAll();
        model.addAttribute("listaClub", listaClub);
        return "verClub";
    }

    @GetMapping("/verClub/formClub")
    public String mostrarFormulario(Model model) {
        model.addAttribute("club", new club());

        List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);

        List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);

        List<Competicion> listaCompeticion = competicionRepositorio.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);

        return "formClub";
    }

    @PostMapping("/guardarClub")
    public String guardarClub(club club) {
        clubRepositorio.save(club);
        return "redirect:/verClub";
    }

    @GetMapping("/club/editar/{id}")
    public String modificarClub(@PathVariable("id") Long id, Model model) {
        club club = clubRepositorio.findById(id).orElse(null);
        model.addAttribute("club", club);

        List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
        model.addAttribute("listaEntrenador", listaEntrenador);

        List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
        model.addAttribute("listaAsociacion", listaAsociacion);

        List<Competicion> listaCompeticion = competicionRepositorio.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);

        return "formClub";
    }

    @GetMapping("/club/eliminar/{id}")
    public String eliminarClub(@PathVariable("id") Long id) {
        clubRepositorio.deleteById(id);
        return "redirect:/verClub";
    }
}
