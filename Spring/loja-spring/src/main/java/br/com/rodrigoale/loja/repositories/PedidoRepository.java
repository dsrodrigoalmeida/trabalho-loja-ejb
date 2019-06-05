package br.com.rodrigoale.loja.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigoale.loja.domain.Cliente;
import br.com.rodrigoale.loja.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	Pedido findByIdPedido(Integer idPedido);

	List<Pedido> findByCliente(Cliente cliente);


}
