package com.vaescode.springboot.horarioInterceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@Value("${spring.view.appController.titulo}")
	private String titulo;
	
	@GetMapping({"/","/index"})
	public String index(Model model) {
		
		model.addAttribute("titulo", titulo );
		return "index";
	}
}
