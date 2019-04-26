package br.com.rodrigoale.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import br.com.rodrigoale.negocio.biz.bean.CarrinhoBean;
import br.com.rodrigoale.negocio.biz.dao.ItensCarrinho;

@SessionScoped
public class ControleCompras implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CarrinhoBean bean;
	
	public void adicionarProduto(String id,String qtd) {
		bean.adicionarProdutoCarrinho(id,qtd);
	}
	
	public List<ItensCarrinho> getCarrinho() {
		return bean.getCarrinho();
	}

	public void removerProduto(String id) {
		bean.removerProdutoCarrinho(id);
		
	}
	
	
}
