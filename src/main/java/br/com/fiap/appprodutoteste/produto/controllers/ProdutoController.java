package br.com.fiap.appprodutoteste.produto.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.fiap.appprodutoteste.produto.dto.ProdutoDto;
import br.com.fiap.appprodutoteste.produto.model.Produto;
import br.com.fiap.appprodutoteste.produto.repositories.ProdutoRepository;


@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/produtos")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("produtos/index");
		           //Long id, String nome, Integer quantidade, BigDecimal valor
		/*Produto produto1 = new Produto(new Long(1), "chocolate", 3, new BigDecimal(2));
		Produto produto2 = new Produto(new Long(2), "chocolate belga", 100, new BigDecimal(40));
		Produto produto3 = new Produto(new Long(4), "chocolate branco", 30, new BigDecimal(20));
		List<Produto> produtos = Arrays.asList(produto1, produto2, produto3); */
		
		List<Produto> produtoDaRepository = produtoRepository.findAll();
		modelView.addObject("listarProdutos", produtoDaRepository);
		
		return modelView;
	}
	
	@GetMapping("/produtos/criar")
	public ModelAndView criar(ProdutoDto produto) {
		ModelAndView modelView = new ModelAndView("produtos/criar");
		return modelView;
	}
	
	@PostMapping("produtos")
	public ModelAndView salvar(@Valid ProdutoDto produto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("produtos/criar");
		}
		
		Produto produtoEntity = modelMapper.map(produto, Produto.class);
		produtoRepository.save(produtoEntity);
		return new ModelAndView("redirect:/produtos");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
