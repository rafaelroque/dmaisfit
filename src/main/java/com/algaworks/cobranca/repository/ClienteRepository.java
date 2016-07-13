package com.algaworks.cobranca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.algaworks.cobranca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public List<Cliente> findByNomeContaining(String nome);
	
	@Query("select c from Cliente c ")
	public List<Cliente> findAll();
}
