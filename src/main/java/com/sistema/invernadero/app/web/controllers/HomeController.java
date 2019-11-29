package com.sistema.invernadero.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("framework", "Spring Boot");
		model.addAttribute("title", "Sistema Invernadero");				
		model.addAttribute("description", "Creación de CRUDs para los catálogos del proyecto");
		return "home";
	}
}
