package br.com.rodrigoale.loja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoale.loja.domain.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
	

	List<Estoque> findByNomeContaining(String nomeProduto);

	Estoque findByNome(String nome);
	Estoque findByIdProduto(Integer idProduto);

}
