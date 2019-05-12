package br.com.rodrigoale.negocio.biz.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.rodrigoale.negocio.biz.model.Produto;

public class Estoque implements IEstoque {
	private Produto produto;
	private List<Estoque> produtos;
	private int qtdEstoque;

	public Estoque() {

		produtos = new ArrayList<Estoque>();
		Produto p1 = new Produto(1, "O Temor do Sabio", 50);
		Produto p2 = new Produto(2, "Senhor dos Aneis", 108);
		Produto p3 = new Produto(3, "Hobbit", 38);
		Produto p4 = new Produto(4, "O Nome do Vento", 42);
		Produto p5 = new Produto(5, "The Legend of Zelda - Breath of the Wild - Creating a Champion", 133);
		Produto p6 = new Produto(6, "Box As Cronicas de Gelo e Fogo", 180);
		Produto p7 = new Produto(7, "The Legend of Zelda - Hyrule Historia", 113);
		Produto p8 = new Produto(8, "Fogo E Sangue - Volume 1", 56);
		Produto p9 = new Produto(9, "Trilogia dos Espinhos", 81);

		Estoque est1 = new Estoque(p1, 10);
		Estoque est2 = new Estoque(p2, 10);
		Estoque est3 = new Estoque(p3, 10);
		Estoque est4 = new Estoque(p4, 10);
		Estoque est5 = new Estoque(p5, 10);
		Estoque est6 = new Estoque(p6, 10);
		Estoque est7 = new Estoque(p7, 10);
		Estoque est8 = new Estoque(p8, 10);
		Estoque est9 = new Estoque(p9, 10);

		produtos.add(est1);
		produtos.add(est2);
		produtos.add(est3);
		produtos.add(est4);
		produtos.add(est5);
		produtos.add(est6);
		produtos.add(est7);
		produtos.add(est8);
		produtos.add(est9);

	}

	private Estoque(Produto produto, int qtdEstoque) {
		this.produto = produto;
		this.qtdEstoque = qtdEstoque;
	}

	public List<Estoque> listaEstoque() {
		return produtos;

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	@Override
	public String toString() {
		return "id: " + this.produto.getId() + " nome: " + this.produto.getNome() + " qtd: " + this.qtdEstoque;
	}
}
