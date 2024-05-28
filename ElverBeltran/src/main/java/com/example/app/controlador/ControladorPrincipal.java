package com.example.app.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {

    @GetMapping("/")
    public String index() {
        return "index"; // Thymeleaf buscará index.html en la carpeta templates
    }
}
