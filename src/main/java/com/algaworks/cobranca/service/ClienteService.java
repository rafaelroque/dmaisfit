package com.algaworks.cobranca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.cobranca.model.Cliente;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.ClienteRepository;
import com.algaworks.cobranca.repository.filter.ClienteFilter;
import com.algaworks.cobranca.repository.filter.TituloFilter;

@Service
public class ClienteService {


	@Autowired
	private ClienteRepository repository;

	public void salvar(Cliente cliente) {
		try {
			repository.save(cliente);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("errro");
		}
	}

	public List<Cliente> filtrar(ClienteFilter filtro) {
		String nome = filtro.getNome() == null ? "%" : filtro.getNome();
		return repository.findByNomeContaining(nome);
	}

	public ClienteRepository getRepository() {
		return repository;
	}

	public void setRepository(ClienteRepository repository) {
		this.repository = repository;
	}

	public List<Cliente> findAll(){
		return getRepository().findAll();
	}

}
