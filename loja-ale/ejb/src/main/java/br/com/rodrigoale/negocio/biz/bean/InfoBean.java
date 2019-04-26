package br.com.rodrigoale.negocio.biz.bean;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.rodrigoale.negocio.biz.dao.Estoque;
import br.com.rodrigoale.negocio.biz.dao.IEstoque;

@Singleton
@Startup
public class InfoBean {
	
	IEstoque estoque = new Estoque();
	
	
	public List<Estoque> listaEstoque() {
		List <Estoque> lista = estoque.listaEstoque();
		return lista;
	}

}
