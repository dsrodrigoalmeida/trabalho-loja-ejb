package br.com.rodrigoale.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigoale.loja.domain.Reposicao;
import br.com.rodrigoale.loja.repositories.ReposicaoRepository;

@Service
public class ReposicaoService {

	@Autowired
	private ReposicaoRepository repo;

	public void insert(Reposicao reposicao) {
		repo.save(reposicao);

	}

	public List<Reposicao> findAll() {
		List <Reposicao> listaReposicao= repo.findAll();
		return listaReposicao;
	}

	public Reposicao findByIdReposicao(Integer idReposicao) {
		Reposicao reposicao = repo.findByIdReposicao(idReposicao);
		return reposicao;
	}

}