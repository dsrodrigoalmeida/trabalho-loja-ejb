package br.com.rodrigoale.negocio.biz.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.rodrigoale.negocio.biz.dao.Estoque;

@Stateless
public class EstoqueBean {

	@Inject
	private InfoBean info;

	public List<Estoque> listarEstoque() {
		return info.listaEstoque();

	}
}
