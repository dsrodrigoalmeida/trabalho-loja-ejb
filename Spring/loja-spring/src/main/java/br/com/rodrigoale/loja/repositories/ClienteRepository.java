package br.com.rodrigoale.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoale.loja.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {


	Cliente findByNomeUsuario(String nomeUsuario);
	
}
