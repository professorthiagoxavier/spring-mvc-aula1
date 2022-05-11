package br.com.fiap.appprodutoteste.produto.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		// Long id, String nome, Integer quantidade, BigDecimal valor
		/*
		 * Produto produto1 = new Produto(new Long(1), "chocolate", 3, new
		 * BigDecimal(2)); Produto produto2 = new Produto(new Long(2),
		 * "chocolate belga", 100, new BigDecimal(40)); Produto produto3 = new
		 * Produto(new Long(4), "chocolate branco", 30, new BigDecimal(20));
		 * List<Produto> produtos = Arrays.asList(produto1, produto2, produto3);
		 */

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
		if (bindingResult.hasErrors()) {
			return new ModelAndView("produtos/criar");
		}

		Produto produtoEntity = modelMapper.map(produto, Produto.class);
		produtoRepository.save(produtoEntity);
		return new ModelAndView("redirect:/produtos");
	}

	@GetMapping("produtos/{id}")
	public ModelAndView mostrar(@PathVariable Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			Produto produtoGet = produto.get();
			ModelAndView modelView = new ModelAndView("produtos/detalhe");
			modelView.addObject("produto", produtoGet);
			return modelView;
		}
		System.out.println("não encontrado!");
		return new ModelAndView("redirect:/produtos");
	}

	@GetMapping("/produtos/{id}/edit")
	public ModelAndView edit(@PathVariable Long id, ProdutoDto request) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);

		if (optionalProduto.isPresent()) {
			Produto produto = optionalProduto.get();
			request.fromProduto(produto);
			ModelAndView model = new ModelAndView("produtos/edit");
			model.addObject("produtoId", produto.getId());
			return model;
		}

		//
		return new ModelAndView("redirect:/produtos");
	}

	@PostMapping("/produtos/{id}")
	public ModelAndView update(@PathVariable Long id, @Valid ProdutoDto request, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			ModelAndView model = new ModelAndView("produtos/edit");
			model.addObject("produtoId", id);
			return model;
		}
		
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		
		if(optionalProduto.isPresent()){
			Produto produto = modelMapper.map(request, Produto.class);
			produto.setId(id);
			produtoRepository.save(produto);
			return new ModelAndView("redirect:/produtos/".concat(produto.getId().toString()));
		}
		
		return new ModelAndView("redirect:/produtos");
	}
	
	@GetMapping("/produtos/{id}/delete")
	public ModelAndView delete(@PathVariable Long id) {
		ModelAndView model = new ModelAndView("redirect:/produtos");
		
		this.produtoRepository.deleteById(id);
		model.addObject("mensagem", "Produto removido com sucesso!");
		return model;
	}
	
	
	
	
	
	
	
	
}
