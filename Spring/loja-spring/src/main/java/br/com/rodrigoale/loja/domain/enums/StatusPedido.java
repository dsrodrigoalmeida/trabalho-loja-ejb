package br.com.rodrigoale.loja.domain.enums;

public enum StatusPedido {

	PROCESSANDO(1, "Em Processamento"), CONCLUIDO(2, "Concluido"), CANCELADO(3 , "Cancelado");

	private int cod;
	private String descricao;

	private StatusPedido(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusPedido toEnum(Integer id) {
		if (id == null)

		{
			return null;
		}
		for (StatusPedido x : StatusPedido.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}