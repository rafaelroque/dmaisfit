package com.algaworks.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.cobranca.model.Cliente;
import com.algaworks.cobranca.model.Titulo;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public List<Cliente> findByNomeContaining(String nome);
}
