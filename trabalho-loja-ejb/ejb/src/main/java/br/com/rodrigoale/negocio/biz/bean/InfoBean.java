package br.com.rodrigoale.negocio.biz.bean;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.rodrigoale.negocio.biz.dao.Estoque;
import br.com.rodrigoale.negocio.biz.dao.IEstoque;

@Singleton
@Startup
public class InfoBean {

	private IEstoque estoque = new Estoque();

	public List<Estoque> listaEstoque() {
		List<Estoque> lista = estoque.listaEstoque();
		return lista;
	}

	public void alterarEstoque(int id, int qtd) {
		List<Estoque> lista = estoque.listaEstoque();

			for (int i = 0; i < lista.size(); i++) {

				if (id == lista.get(i).getProduto().getId()) {
					lista.get(i).setQtdEstoque(qtd);
				}
			}
		}





	public Estoque selecionarProdutoDoEstoque(int id) {
		List<Estoque> lista = estoque.listaEstoque();
		for (int i=0; i< lista.size(); i++) {
			if(lista.get(i).getProduto().getId() == id) {
				return lista.get(i);
			}
		}
		return null;

		
	}

}
