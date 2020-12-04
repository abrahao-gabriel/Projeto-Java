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

import com.aula.model.Musica;
import com.aula.model.MusicaService;

@Controller
public class MusicaUpdController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/upd/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		MusicaService mdao = context.getBean(MusicaService.class);
		Map<String,Object> antigo = mdao.getMusica(id);
		Musica musica = new Musica((String)antigo.get("nome"), (String)antigo.get("artista"), (String)antigo.get("gravadora"),(String)antigo.get("estilo"));
		model.addAttribute("antigo",musica);
		model.addAttribute("id");
		return "formmusicaupd";
	}
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute Musica musica, Model model) {
		MusicaService mdao = context.getBean(MusicaService.class);
		mdao.updateMusica(id, musica);
		return "redirect:/musicas";
	}
	
}
