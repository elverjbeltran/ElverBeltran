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
public class controladorWebJugador {

    @Autowired
    private crudJugador jugadorRepositorio;

    @Autowired
    private CrudClub clubRepositorio;

    @GetMapping("/verJugador")
    public String listarJugador(Model model) {
        List<Jugador> listaJugador = jugadorRepositorio.findAll();
        model.addAttribute("listaJugador", listaJugador);
        return "verJugador";
    }

    @GetMapping("/verJugador/formJugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador());

        List<club> listaClub = clubRepositorio.findAll();
        model.addAttribute("listaClub", listaClub);

        return "formJugador";
    }

    @PostMapping("/guardarJugador")
    public String guardarJugador(Jugador jugador) {
        jugadorRepositorio.save(jugador);
        return "redirect:/verJugador";
    }

    @GetMapping("/jugador/editar/{id}")
    public String modificarJugador(@PathVariable("id") Long id, Model model) {
        Jugador jugador = jugadorRepositorio.findById(id).get();
        model.addAttribute("jugador", jugador);

        List<club> listaClub = clubRepositorio.findAll();
        model.addAttribute("listaClub", listaClub);

        return "formJugador";
    }

    @GetMapping("/jugador/eliminar/{id}")
    public String eliminarJugador(@PathVariable("id") Long id, Model model) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/verJugador";
    }
}

