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

import com.sistema.invernadero.app.web.models.entities.Cultivo;
import com.sistema.invernadero.app.web.models.service.ICultivoService;

@RequestMapping(value="/cultivo")
@Controller
public class CultivoController {
	@Autowired
	private ICultivoService service;
	
	@GetMapping(value="/create")
	public String create(Model model) {
		Cultivo cultivo=new Cultivo();
		
		model.addAttribute("cultivo",cultivo);
		model.addAttribute("tittle","Registro de un nuevo cultivo");
		
		return "/cultivo/form";
	}
	
	@GetMapping(value="/retrieve/{id}")
	public String retrive(@PathVariable(value="id")Integer id,Model model) {
		Cultivo cultivo=service.findById(id);
		model.addAttribute("cultivo",cultivo);
		return "/cultivo/card";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id")Integer id,Model model) {
		Cultivo cultivo = service.findById(id);
		model.addAttribute("cultivo",cultivo);
		model.addAttribute("tittle","Actualizando cultivo"+cultivo.getIdcultivo());
		return "/cultivo/form";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete (@PathVariable(value="id")Integer id,Model model, RedirectAttributes redirect) {
		try {
			service.delete(id);
			redirect.addFlashAttribute("message","El registro se eliminó exitosamente");
		} catch (Exception ex) {
			// TODO: handle exception
			redirect.addFlashAttribute("message","El registro no pudo ser borrado");
		}
		return "redirect:/cultivo/list";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Cultivo>list=service.findAll();
		model.addAttribute("list",list);
		model.addAttribute("tittle","Listado de cultivos");
		return "/bloque/list";
	}
	
	@PostMapping(value="/save")
	public String save(Cultivo cultivo,Model model, RedirectAttributes redirect) {
		try {
			service.save(cultivo);
			redirect.addFlashAttribute("message","Registro guardado con éxito");
		} catch (Exception ex) {
			// TODO: handle exception
			redirect.addFlashAttribute("error","No se pudo guardar el registro");
		}
		return"redirect:/cultivo/list";
	}
}
