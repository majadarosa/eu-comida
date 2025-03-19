package com.geosapiens.eu_comida.security.auth;

public enum Role {
	ROLE_ADMIN("ROLE_ADMIN"), ROLE_ENTREGADOR("ROLE_ENTREGADOR");

	private String descricao;

	Role(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
