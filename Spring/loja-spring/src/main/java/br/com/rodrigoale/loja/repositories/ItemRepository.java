package br.com.rodrigoale.loja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoale.loja.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
	



}
