package com.sistema.invernadero.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sistema.invernadero.app.web.models.entities.Planta;
import com.sistema.invernadero.app.web.models.service.IPlantaService;

@RequestMapping(value="/planta")
@Controller
public class PlantaController {

	@Autowired
	private IPlantaService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Planta planta = new Planta();
		model.addAttribute("title", "Registro de una Planta");
		model.addAttribute("planta", planta);
		return "planta/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Planta planta = service.findById(id);
		model.addAttribute("planta", planta);
		return "planta/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Planta planta = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ planta.getNombre());
		model.addAttribute("planta", planta);
		return "planta/form";		
	} 
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, 
			RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro fue eliminado con éxito.");
		}	
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser eliminado.");
		}
		return "redirect:/planta/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Planta planta,BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				model.addAttribute("tittle","Error al Guardar");
				return"planta/form";
			}
			service.save(planta);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/planta/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Planta> lista = service.findAll();
		model.addAttribute("title", "Listado de Plantas");
		model.addAttribute("lista", lista);
		return "planta/list";		
	} 
	
}
