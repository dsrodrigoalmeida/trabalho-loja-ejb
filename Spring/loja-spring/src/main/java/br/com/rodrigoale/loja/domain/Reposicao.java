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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.rodrigoale.loja.domain.enums.StatusReposicao;

@Entity
public class Reposicao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReposicao;
	private Integer status;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Pedido pedido;
	

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="reposicao_nome")
	private List<Item> produtos = new ArrayList<>();

	public Reposicao() {

	}

	public Reposicao(Integer idReposicao, StatusReposicao status, Pedido pedido) {
		this.idReposicao = idReposicao;
		this.status = status.getCod();
		this.pedido = pedido;
		}

	public Integer getIdReposicao() {
		return idReposicao;
	}

	public void setIdReposicao(Integer idReposicao) {
		this.idReposicao = idReposicao;
	}

	
	  public List<Item> getProdutos() { return produtos; }
	  
	  
	  public void setProdutos(List<Item> produtos) { this.produtos = produtos; }
	 

	  public StatusReposicao getStatus() {
			return StatusReposicao.toEnum(status);
		}

		public void setStatus(StatusReposicao status) {
			this.status = status.getCod();
	}	

		
	


	public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReposicao == null) ? 0 : idReposicao.hashCode());
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
		Reposicao other = (Reposicao) obj;
		if (idReposicao == null) {
			if (other.idReposicao != null)
				return false;
		} else if (!idReposicao.equals(other.idReposicao))
			return false;
		return true;
	}

}
