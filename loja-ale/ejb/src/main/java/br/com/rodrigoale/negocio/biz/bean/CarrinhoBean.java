package br.com.rodrigoale.negocio.biz.bean;

import java.util.List;

import javax.ejb.Stateful;


import br.com.rodrigoale.negocio.biz.dao.ItensCarrinho;

@Stateful
public class CarrinhoBean {
	 

	ItensCarrinho itens  = new ItensCarrinho();
	
	public void adicionarProdutoCarrinho(String idString, String qtdString) {
		itens.adicionarProdutoCarrinho(idString, qtdString);
	}

	public void removerProdutoCarrinho(String idString) {
		itens.removerProdutoCarrinho(idString);
			
	}

	public List<ItensCarrinho> getCarrinho() {
		
		return itens.getCarrinho();
	}

}
