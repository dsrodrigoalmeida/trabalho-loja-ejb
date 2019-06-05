package br.com.rodrigoale.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoale.loja.domain.Reposicao;

@Repository
public interface ReposicaoRepository extends JpaRepository<Reposicao, Integer> {

	Reposicao findByIdReposicao(Integer idReposicao);


}
