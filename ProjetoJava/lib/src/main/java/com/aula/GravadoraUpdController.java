package com.aula;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.model.Gravadora;
import com.aula.model.GravadoraService;

@Controller
public class GravadoraUpdController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/updG/{id}")
	public String readG(@PathVariable("id") int id, Model model) {
		GravadoraService gdao = context.getBean(GravadoraService.class);
		Map<String,Object> antigoG = gdao.getGravadora(id);
		Gravadora gravadora = new Gravadora((String)antigoG.get("nome"), (String)antigoG.get("email"));
		model.addAttribute("antigoG",gravadora);
		model.addAttribute("id");
		return "formgravadoraupd";
	}
	
	@PostMapping("/updG/{id}")
	public String updateG(@PathVariable("id") int id, @ModelAttribute Gravadora gravadora, Model model) {
		GravadoraService gdao = context.getBean(GravadoraService.class);
		gdao.updateGravadora(id, gravadora);
		return "redirect:/gravadoras";
	}
}
