package com.algaworks.cobranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobranca.model.Cliente;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.filter.ClienteFilter;
import com.algaworks.cobranca.repository.filter.TituloFilter;
import com.algaworks.cobranca.service.CadastroTituloService;
import com.algaworks.cobranca.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	private static final String CADASTRO_VIEW = "cliente/CadastroCliente";
	private static final String LISTAGEM_VIEW = "cliente/ListagemClientes";

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Cliente());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		try {
			service.salvar(cliente);
			attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso!");
			return "redirect:/clientes/novo";
		} catch (IllegalArgumentException e) {
			return CADASTRO_VIEW;
		}
	}
	
	@RequestMapping
	public ModelAndView pesquisar(@ModelAttribute("filtro") ClienteFilter filtro) {
		List<Cliente> clientes = service.filtrar(filtro);
		
		ModelAndView mv = new ModelAndView(LISTAGEM_VIEW);
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	//@RequestMapping("/todos")
	public List<Cliente> todos(){
		List<Cliente> l = service.getRepository().findAll(); 
		return l ;
	}
	
}
