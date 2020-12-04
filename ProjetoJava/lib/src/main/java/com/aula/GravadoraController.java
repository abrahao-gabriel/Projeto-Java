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
public class GravadoraController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/gravadora")
	public String cadastrarG(Model model) {
		model.addAttribute("gravadora", new Gravadora());
		return "formgravadora";
		
	}
	
	@PostMapping("/gravadora")
	public String acaoG(@ModelAttribute Gravadora gravadora, Model model) {
		model.addAttribute("gravadora", gravadora);
		GravadoraService gdao = context.getBean(GravadoraService.class);
		gdao.insertG(gravadora);
		return "sucessogravadora";
	}
	
	//listar 1
	@GetMapping("descrG/{id}")
	public String readG(@PathVariable("id") int id, Model model) {
		GravadoraService gdao = context.getBean(GravadoraService.class);
		Map<String, Object> gravadora = gdao.getGravadora(id);
		Gravadora grav= new Gravadora((String)gravadora.get("nome"),(String)gravadora.get("email"));
		model.addAttribute("gravadora",grav);
		return "sucessogravadora";
	}
	
	//listar tudo
	@GetMapping("/gravadoras")
	public String listarG(Model model) {
		GravadorasService gdao = context.getBean(GravadoraService.class);
		List<Map<String,Object>> gravadoras = gdao.getGravadoras();
		model.addAttribute("gravadoras",gravadoras);
		return "listagravadora";
	}
	
	@PostMapping("/apagarG/{id}")
	public String deletarG(@PathVariable("id") int id, Model model) {
		GravadoraService gdao = context.getBean(GravadoraService.class);
		gdao.deleteGravadora(id);
		return "redirect:/gravadoras";
	}
}