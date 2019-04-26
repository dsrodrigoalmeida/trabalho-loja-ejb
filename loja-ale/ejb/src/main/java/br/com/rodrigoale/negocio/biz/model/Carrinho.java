package br.com.rodrigoale.negocio.biz.model;

public class Carrinho {
	private Produto produto;
	private int qtdCarrinho;
	private double subtotal;

	public Carrinho(Produto produto, int qtdCarrinho) {
		this.produto = produto;
		this.qtdCarrinho = qtdCarrinho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQtdCarrinho() {
		return qtdCarrinho;
	}

	public void setQtdCarrinho(int qtdCarrinho) {
		this.qtdCarrinho = qtdCarrinho;
	}
}
