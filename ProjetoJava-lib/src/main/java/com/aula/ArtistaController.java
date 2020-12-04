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
public class ArtistaController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/artista")
	public String cadastrarA(Model model) {
		model.addAttribute("artista", new Artista());
		return "formartista";
		
	}
	
	@PostMapping("/artista")
	public String acaoA(@ModelAttribute Artista artista, Model model) {
		model.addAttribute("artista", artista);
		ArtistaService adao = context.getBean(ArtistaService.class);
		adao.insertA(artista);
		return "sucessoartista";
	}
	
	//listar 1
	@GetMapping("descrA/{id}")
	public String readA(@PathVariable("id") int id, Model model) {
		ArtistaService adao = context.getBean(ArtistaService.class);
		Map<String, Object> artista = adao.getArtista(id);
		Artista art = new Artista((String)artista.get("nome"),(String)artista.get("email"));
		model.addAttribute("artista",art);
		return "sucessoartista";
	}
	
	//listar tudo
	@GetMapping("/artistas")
	public String listarA(Model model) {
		ArtistaService adao = context.getBean(ArtistaService.class);
		List<Map<String,Object>> artistas = adao.getArtistas();
		model.addAttribute("artistas",artistas);
		return "listaartista";
	}
	
	@PostMapping("/apagarA/{id}")
	public String deletarA(@PathVariable("id") int id, Model model) {
		ArtistaService adao = context.getBean(ArtistaService.class);
		adao.deleteArtista(id);
		return "redirect:/artistas";
	}
}
