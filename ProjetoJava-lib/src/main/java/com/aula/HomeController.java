package com.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String Principal(Model model) {
		return "principal";
	}
}
