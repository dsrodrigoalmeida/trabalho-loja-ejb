package br.com.rodrigoale.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigoale.loja.domain.Estoque;
import br.com.rodrigoale.loja.repositories.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repo;

	public List<Estoque> findByNomeContaining(String nomeProduto) {
		List<Estoque> produtos = repo.findByNomeContaining(nomeProduto);
		return produtos;
	}

	public Estoque findByNome(String nome) {
		Estoque produto = repo.findByNome(nome);
		return produto;
	}

	public void insert(Estoque produto) {
		repo.save(produto);
		
	}

	public Estoque findByIdProduto(Integer idProduto) {
		Estoque produto = repo.findByIdProduto(idProduto);
		return produto;
	}

	public List<Estoque> findAll() {
		List <Estoque> produtos =repo.findAll();
		return produtos;
	}


}