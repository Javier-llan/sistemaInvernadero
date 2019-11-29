package com.sistema.invernadero.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sistema.invernadero.app.web.models.entities.Bloque;
import com.sistema.invernadero.app.web.models.service.IBloqueService;

@RequestMapping(value="/bloque")
@Controller
public class BloqueController {

	@Autowired
	private IBloqueService service;
	//crear
	@GetMapping(value="create")
	public String create(Model model) {
		Bloque bloque = new Bloque();
	    model.addAttribute("bloque",bloque);
	    model.addAttribute("tittle","Registro de un nuevo bloque");
	    
		return "/bloque/form";	
	}
	
	@GetMapping(value="/retrieve/{id}")
	public 	String retrive(@PathVariable(value="id")Integer id,Model model) {
		Bloque bloque = service.findById(id);
		model.addAttribute("bloque",bloque);
		
		return "/bloque/card";
	}
	
	//Actualizar
		@GetMapping(value="update/{id}")
		public String update(@PathVariable(value="id") Integer id, Model model) {
			Bloque bloque=service.findById(id);
			model.addAttribute("bloque",bloque);
			model.addAttribute("tittle","Se ha actualizado un bloque"+bloque.getNombre());
			return "/bloque/form";
	    }
	
	//delete
		@GetMapping(value="/delete/{id}")
		public String delete(@PathVariable(value="id")Integer id,Model model, RedirectAttributes redirect) {
			try {
				service.delete(id);
				redirect.addFlashAttribute("message","El registro se eliminó exitosamente");
			} catch (Exception ex) {
				// TODO: handle exception
				redirect.addFlashAttribute("message","El registro no pudo ser borrado");
			}
			return "redirect:/bloque/list";
		}
		
		
		@PostMapping(value="/save")
		public String save(Bloque bloque,Model model, RedirectAttributes redirect) {
			try {
				service.save(bloque);
				redirect.addFlashAttribute("message","Registro guardado con éxito");
			} catch (Exception ex) {
				// TODO: handle exception
				redirect.addFlashAttribute("error","No se pudo guardar el registro");
			}
			return"redirect:/bloque/list";
		}
		
		@GetMapping(value="/list")
		public String list(Model model) {
			List<Bloque>list=service.findAll();
			model.addAttribute("list",list);
			model.addAttribute("tittle","Listado de bloques");
			return "/bloque/list";
		}
		
}
