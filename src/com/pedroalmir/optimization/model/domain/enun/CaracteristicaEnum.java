/**
 * 
 */
package com.pedroalmir.optimization.model.domain.enun;

/**
 * @author Pedro Almir
 */
public enum CaracteristicaEnum {
	PESO("Peso");
	
	/**
	 * 
	 */
	private String descricao;

	/**
	 * @param descricao
	 */
	private CaracteristicaEnum(String descricao) {
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
