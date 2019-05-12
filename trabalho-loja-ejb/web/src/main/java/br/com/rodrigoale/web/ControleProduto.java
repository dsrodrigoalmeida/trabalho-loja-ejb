package br.com.rodrigoale.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import br.com.rodrigoale.negocio.biz.bean.EstoqueBean;
import br.com.rodrigoale.negocio.biz.dao.Estoque;

@SessionScoped
public class ControleProduto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EstoqueBean bean;
	
	public List<Estoque> listar() {
		return bean.listarEstoque();
	}
	
	public void alterarEstoque (int id, int qtd) {
		bean.aumentarEstoque(id, qtd);
	}
	
	public Estoque selecionarProdutoDoEstoque(int id) {
		
		return bean.selecionarProdutoDoEstoque(id);
	}
}
