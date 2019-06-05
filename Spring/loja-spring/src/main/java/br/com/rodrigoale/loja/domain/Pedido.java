package br.com.rodrigoale.loja.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.rodrigoale.loja.domain.enums.StatusPedido;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;
	private Integer status;

	
	
	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Cliente cliente;

	@OneToMany(cascade = {CascadeType.ALL})
	private List<Item> produtos = new ArrayList<>();

	public Pedido() {

	}

	public Pedido(Integer idPedido, StatusPedido status, Cliente cliente) {
		this.idPedido = idPedido;
		this.status = status.getCod();
		this.cliente = cliente;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setId(Integer idPedido) {
		this.idPedido = idPedido;
	}

	
	  public List<Item> getProdutos() { return produtos; }
	  
	  
	  public void setProdutos(List<Item> produtos) { this.produtos = produtos; }
	 

	  public StatusPedido getStatus() {
			return StatusPedido.toEnum(status);
		}

		public void setStatus(StatusPedido status) {
			this.status = status.getCod();
	}	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", status=" + status + ", cliente=" + cliente + ", produtos=" + produtos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedido == null) ? 0 : idPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (idPedido == null) {
			if (other.idPedido != null)
				return false;
		} else if (!idPedido.equals(other.idPedido))
			return false;
		return true;
	}

}
