/**
 * 
 */
package com.pedroalmir.optimization.model.domain.enun;

/**
 * @author Pedro Almir
 *
 */
public enum GrupoContemporaneosEnum {
	ANO("Ano da última coleta"), SEXO("Sexo do animal");
	
	private String descricao;
	
	/**
	 * @param descricao
	 */
	private GrupoContemporaneosEnum(String descricao) {
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
	
	/**
	 * @param descricao
	 * @return
	 */
	public static GrupoContemporaneosEnum getEnum(String descricao){
		for(GrupoContemporaneosEnum enun : GrupoContemporaneosEnum.values()){
			if(enun.getDescricao().equals(descricao)){
				return enun;
			}
		}
		return null;
	}
}
