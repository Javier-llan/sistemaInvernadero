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

import com.sistema.invernadero.app.web.models.entities.Responsable;
import com.sistema.invernadero.app.web.models.service.IResponsableService;

@RequestMapping(value="/responsable")
@Controller
public class ResponsableController {
	
	@Autowired
	private IResponsableService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Responsable responsable = new Responsable();
		model.addAttribute("title", "Registro de un Responsable");
		model.addAttribute("responsable", responsable);
		return "responsable/form";		
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrieve(@PathVariable(value="id") Integer id, Model model) {
		Responsable responsable = service.findById(id);
		model.addAttribute("responsable", responsable);
		return "responsable/card";		
	} 
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Responsable responsable = service.findById(id);
		model.addAttribute("title", "Actualizando el registro de " 
		+ responsable.getApellido());
		model.addAttribute("responsable", responsable);
		return "responsable/form";		
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
		return "redirect:/responsable/list";		
	} 
	
	@PostMapping(value="/save")
	public String save(@Valid Responsable responsable,BindingResult result, Model model,
			RedirectAttributes flash) {
		try {
			if(result.hasErrors())
			{
				model.addAttribute("tittle","Error al Guardar");
				return"responsable/form";
			}
			service.save(responsable);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		}
		catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/responsable/list";		
	} 
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Responsable> lista = service.findAll();
		model.addAttribute("title", "Listado de Responsable");
		model.addAttribute("lista", lista);
		return "responsable/list";		
	} 
	
	
}
