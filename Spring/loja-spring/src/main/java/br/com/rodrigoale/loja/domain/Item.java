package br.com.rodrigoale.loja.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItem;
	private String nome;
	private Integer quantidade;
	private Double valor;
	
	
	public Item() {
		
	}

	

	public Item(Integer idItem, String nome, Integer quantidade, Double valor) {
		this.idItem = idItem;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}


	public Integer getIdItem() {
		return idItem;
	}


	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}

	

	@Override
	public String toString() {
		return "Produto [idItem=" + idItem + ", nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor
				+ "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idItem == null) ? 0 : idItem.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!idItem.equals(other.idItem))
			return false;
		return true;
	}

	
	
}
