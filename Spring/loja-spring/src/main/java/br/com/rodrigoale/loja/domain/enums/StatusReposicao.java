package br.com.rodrigoale.loja.domain.enums;

public enum StatusReposicao {

	PROCESSANDO(1, "Em Processamento"), CONCLUIDO(2, "Concluido");

	private int cod;
	private String descricao;

	private StatusReposicao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusReposicao toEnum(Integer id) {
		if (id == null)

		{
			return null;
		}
		for (StatusReposicao x : StatusReposicao.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}