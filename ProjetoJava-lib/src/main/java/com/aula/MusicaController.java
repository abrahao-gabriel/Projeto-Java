package com.aula;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.model.Musica;
import com.aula.model.MusicaService;

@Controller
public class MusicaController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/musica")
	public String cadastrar(Model model) {
		model.addAttribute("musica", new Musica());
		return "formmusica";
		
	}
	
	@PostMapping("/musica")
	public String acao(Musica musica, Model model) {
		model.addAttribute("musica", musica);
		MusicaService mdao = context.getBean(MusicaService.class);
		mdao.insert(musica);
		return "sucessomusica";
	}
	
	//listar 1
	@GetMapping("descr/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		MusicaService mdao = context.getBean(MusicaService.class);
		Map<String, Object> musica = mdao.getMusica(id);
		Musica music = new Musica((String)musica.get("nome"),(String)musica.get("artista"),(String)musica.get("gravadora"),(String)musica.get("estilo"));
		model.addAttribute("musica",music);
		return "sucessomusica";
	}
	
	//listar tudo
	@GetMapping("/musicas")
	public String listar(Model model) {
		MusicaService mdao = context.getBean(MusicaService.class);
		List<Map<String,Object>> musicas = mdao.getMusicas();
		model.addAttribute("musicas",musicas);
		return "listamusica";
	}
	
}
