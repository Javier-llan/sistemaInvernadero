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


import com.sistema.invernadero.app.web.models.entities.Cuidado;
import com.sistema.invernadero.app.web.models.service.ICuidadoService;

@RequestMapping(value="/cuidado")
@Controller
public class CuidadoController {
	@Autowired
	private ICuidadoService service;
	
	//crear
		@GetMapping(value="create")
		public String create(Model model) {
			Cuidado cuidado = new Cuidado();
		    model.addAttribute("cuidado",cuidado);
		    model.addAttribute("tittle","Registro de un nuevo cuidado");
		    
			return "/cuidado/form";	
		}
		
		@GetMapping(value="/retrieve/{id}")
		public 	String retrive(@PathVariable(value="id")Integer id,Model model) {
			Cuidado cuidado = service.findById(id);
			model.addAttribute("cuidado",cuidado);
			
			return "/cuidado/card";
		}
		
		//Actualizar
			@GetMapping(value="update/{id}")
			public String update(@PathVariable(value="id") Integer id, Model model) {
				Cuidado cuidado=service.findById(id);
				model.addAttribute("cuidado",cuidado);
				model.addAttribute("tittle","Se ha actualizado un cuidado"+cuidado.getNombre());
				return "/cuidado/form";
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
				return "redirect:/cuidado/list";
			}
			
			@GetMapping(value="/list")
			public String list(Model model) {
				List<Cuidado>list=service.findAll();
				model.addAttribute("list",list);
				model.addAttribute("tittle","Listado de cuidados");
				return "/cuidado/list";
			}
			
			@PostMapping(value="/save")
			public String save(Cuidado cuidado,Model model, RedirectAttributes redirect) {
				try {
					service.save(cuidado);
					redirect.addFlashAttribute("message","Registro guardado con éxito");
				} catch (Exception ex) {
					// TODO: handle exception
					redirect.addFlashAttribute("error","No se pudo guardar el registro");
				}
				return"redirect:/cuidado/list";
			}
}
