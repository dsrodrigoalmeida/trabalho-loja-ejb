package br.com.rodrigoale.loja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigoale.loja.domain.Cliente;
import br.com.rodrigoale.loja.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente findByNomeUsuario(String nomeUsuario) {
		Cliente cliente = repo.findByNomeUsuario(nomeUsuario);
		return cliente;
	}

	public void insert(Cliente cliente) {
		repo.save(cliente);
		
	}

	
	
}