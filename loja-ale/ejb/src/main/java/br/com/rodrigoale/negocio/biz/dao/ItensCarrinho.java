package br.com.rodrigoale.negocio.biz.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.rodrigoale.negocio.biz.model.Produto;

public class ItensCarrinho {
	double total;
	int qtdCarrinho;
	
	Produto produto = new Produto();
	List<ItensCarrinho> carrinho = new ArrayList<>();
	
	private ItensCarrinho (Produto produto, int qtdCarrinho, double total) {
		this.produto=produto;
		this.qtdCarrinho=qtdCarrinho;
		this.total = total;
	
	}
	


	public ItensCarrinho() {
		
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public int getQtdCarrinho() {
		return qtdCarrinho;
	}



	public void setQtdCarrinho(int qtdCarrinho) {
		this.qtdCarrinho = qtdCarrinho;
	}



	public Produto getProduto() {
		return produto;
	}



	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	public void setCarrinho(List<ItensCarrinho> carrinho) {
		this.carrinho = carrinho;
	}



	public void adicionarProdutoCarrinho(String idString, String qtdString) {
		montarProduto(idString, qtdString);
		 qtdCarrinho = Integer.parseInt(qtdString);
		produto.setSubtotal(produto.getPreco()*qtdCarrinho);  
		total +=  produto.getSubtotal();
		carrinho.add(new ItensCarrinho(produto,qtdCarrinho,total));
		
	}

	public void removerProdutoCarrinho(String idString) {
		int id = Integer.parseInt(idString);
		for (int i=0;i< carrinho.size(); i++) {
			if(carrinho.get(i).getProduto().getId() ==(id)) {
				carrinho.get(i).total -= carrinho.get(i).getProduto().getSubtotal();
				carrinho.remove(i);
			}
		}
	}

	public List<ItensCarrinho> getCarrinho() {
		
		return carrinho;
	}

	private void montarProduto (String idString, String qtdString) {
		int id = Integer.parseInt(idString);
		produto = new Produto();
		switch (id) {
		
		case 1:

			produto.setNome("O Temor do Sabio");
			produto.setPreco(50);
			produto.setId(id);
			break;

		case 2:

			produto.setNome("Senhor dos Aneis");
			produto.setPreco(108);
			produto.setId(id);
			produto.setId(id);
			break;
			
		case 3:

			produto.setNome("Hobbit");
			produto.setPreco(38);
			produto.setId(id);
			break;
		
		case 4:

			produto.setNome("O Nome do Vento");
			produto.setPreco(42);
			produto.setId(id);
			break;
		
		case 5:
			
			produto.setNome("The Legend of Zelda: Breath of the Wild-Creating a Champion");
			produto.setPreco(133);
			produto.setId(id);
			break;
		
		case 6:

			produto.setNome("Box As Cronicas de Gelo e Fogo");
			produto.setPreco(180);
			produto.setId(id);
			break;

		case 7:

			produto.setNome("The Legend of Zelda: Hyrule Historia");
			produto.setPreco(113);
			produto.setId(id);
			break;

		case 8:

			produto.setNome("Fogo E Sangue - Volume 1");
			produto.setPreco(56);
			produto.setId(id);
			break;

		case 9:

			produto.setNome("Trilogia dos Espinhos");
			produto.setPreco(81);
			produto.setId(id);
			break;

		}
	}


}
