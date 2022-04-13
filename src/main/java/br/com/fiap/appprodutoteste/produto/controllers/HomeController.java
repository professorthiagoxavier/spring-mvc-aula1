package br.com.fiap.appprodutoteste.produto.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("nomeUsuario", "Thiago Souza Xavier");
		
		return "home";
	}

}
