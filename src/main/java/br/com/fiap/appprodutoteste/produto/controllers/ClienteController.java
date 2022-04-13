package br.com.fiap.appprodutoteste.produto.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.appprodutoteste.produto.dto.ClienteDto;
import br.com.fiap.appprodutoteste.produto.model.Cliente;
import br.com.fiap.appprodutoteste.produto.repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/clientes")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("clientes/index");
		
		List<Cliente> listarCliente = clienteRepository.findAll();
		model.addObject("listarCliente", listarCliente);
		
		return model;
	}
	
	@GetMapping("cliente/criar")
	public ModelAndView criar(ClienteDto model) {
		return new ModelAndView("clientes/criar");
	}
	
	@PostMapping("/cliente")
	public ModelAndView salvar(@Valid ClienteDto model, BindingResult bindingResult) 
	{
		if(bindingResult.hasErrors()) {
			ModelAndView modelView = new ModelAndView("clientes/criar");
			return modelView;
		}
		
		Cliente cliente = modelMapper.map(model, Cliente.class);
		clienteRepository.save(cliente);
		return new ModelAndView("redirect:/clientes");
	}
	
	
	
	
	
	
	
	
	
}
