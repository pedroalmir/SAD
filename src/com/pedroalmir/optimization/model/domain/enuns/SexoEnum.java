/**
 * 
 */
package com.pedroalmir.optimization.model.domain.enuns;

/**
 * @author Pedro Almir
 */
public enum SexoEnum {
	MACHO("Macho"), FEMEA("Fêmea");
	
	/**
	 * 
	 */
	private String descricao;

	/**
	 * @param descricao
	 */
	private SexoEnum(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
