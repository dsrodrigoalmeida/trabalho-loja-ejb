package br.com.rodrigoale.loja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rodrigoale.loja.domain.Cliente;
import br.com.rodrigoale.loja.domain.Pedido;
import br.com.rodrigoale.loja.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public void insert(Pedido pedido) {
		repo.save(pedido);

	}
	
	public Pedido findByIdPedido(Integer idPedido) {
		Pedido pedido = repo.findByIdPedido(idPedido);
		return pedido;
		
	}

	public List<Pedido> findByCliente(Cliente cliente) {
		List<Pedido> listaPedido = repo.findByCliente(cliente);
		return listaPedido;
	}
	
	public List<Pedido> findAll() {
		List<Pedido> listaPedido = repo.findAll();
		
		return listaPedido;
	}

}