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

import com.aula.model.Artista;
import com.aula.model.ArtistaService;

@Controller
public class ArtistaUpdController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/updA/{id}")
	public String readA(@PathVariable("id") int id, Model model) {
		ArtistaService adao = context.getBean(ArtistaService.class);
		Map<String,Object> antigoA = adao.getArtista(id);
		Artista artista = new Artista((String)antigoA.get("nome"), (String)antigoA.get("email"));
		model.addAttribute("antigoA",artista);
		model.addAttribute("id");
		return "formartistaupd";
	}
	
	@PostMapping("/updA/{id}")
	public String updateA(@PathVariable("id") int id, @ModelAttribute Artista artista, Model model) {
		ArtistaService adao = context.getBean(ArtistaService.class);
		adao.updateArtista(id, artista);
		return "redirect:/artistas";
	}
}
