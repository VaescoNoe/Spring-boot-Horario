package com.vaescode.springboot.horarioInterceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@Value("${spring.view.appController.titulo}")
	private String titulo;
	
	@Value("${spring.view.appController.tituloCerrado}")
	private String tituloCerrado;
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@GetMapping({"/","/index"})
	public String index(Model model) {
		
		model.addAttribute("titulo", titulo );
		return "index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		
		StringBuilder mensaje = new StringBuilder("Cerrado, por favor visítenos desde las ");
		mensaje.append(apertura);
		mensaje.append(" y las ");
		mensaje.append(cierre);
		mensaje.append(" hrs. Gracias.");
		
		model.addAttribute("titulo", tituloCerrado);
		model.addAttribute("mensaje", mensaje.toString());
		return "cerrado";
	}
	
}
