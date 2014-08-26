package com.pedroalmir.optimization.model.domain;

import java.util.Date;
import java.util.HashMap;

import com.pedroalmir.optimization.model.domain.enuns.SexoEnum;

/**
 * @author Pedro Almir
 */
public class Animal {
	private Long idAnimal;
	private Long idPai;
	private Long idMae;
	
	private Date dataNascimento;
	private Date dataColeta;
	private SexoEnum sexo;
	
	private double peso;
	private boolean vivo;
	private boolean aptoAcasalamento;
	
	/**
	 * 
	 */
	public Animal() {
		
	}	
	
	/**
	 * @param idAnimal
	 * @param idPai
	 * @param idMae
	 * @param dataNascimento
	 * @param dataColeta
	 * @param sexo
	 * @param peso
	 * @param vivo
	 */
	public Animal(Long idAnimal, Long idPai, Long idMae, Date dataNascimento,
			Date dataColeta, SexoEnum sexo, double peso, boolean vivo) {
		super();
		this.idAnimal = idAnimal;
		this.idPai = idPai;
		this.idMae = idMae;
		this.dataNascimento = dataNascimento;
		this.dataColeta = dataColeta;
		this.sexo = sexo;
		this.peso = peso;
		this.vivo = vivo;
	}

	/**
	 * @param parameters
	 */
	public Animal(HashMap<String, Object> parameters) {
		this.idAnimal = (Long) parameters.get("idAnimal");
		this.idPai = (Long) parameters.get("idPai");
		this.idMae = (Long) parameters.get("idMae");
		this.dataNascimento = (Date) parameters.get("dataNascimento");
		this.dataColeta = (Date) parameters.get("dataColeta");
		this.sexo = (SexoEnum) parameters.get("sexo");
		this.peso = (Double) parameters.get("peso");
		this.vivo = (Boolean) parameters.get("vivo");
	}

	/**
	 * @return the idAnimal
	 */
	public Long getIdAnimal() {
		return idAnimal;
	}

	/**
	 * @param idAnimal the idAnimal to set
	 */
	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}
	/**
	 * @return the idPai
	 */
	public Long getIdPai() {
		return idPai;
	}
	/**
	 * @param idPai the idPai to set
	 */
	public void setIdPai(Long idPai) {
		this.idPai = idPai;
	}
	/**
	 * @return the idMae
	 */
	public Long getIdMae() {
		return idMae;
	}
	/**
	 * @param idMae the idMae to set
	 */
	public void setIdMae(Long idMae) {
		this.idMae = idMae;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the dataColeta
	 */
	public Date getDataColeta() {
		return dataColeta;
	}
	/**
	 * @param dataColeta the dataColeta to set
	 */
	public void setDataColeta(Date dataColeta) {
		this.dataColeta = dataColeta;
	}
	/**
	 * @return the sexo
	 */
	public SexoEnum getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the peso
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}
	/**
	 * @return the vivo
	 */
	public boolean isVivo() {
		return vivo;
	}
	/**
	 * @param vivo the vivo to set
	 */
	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}
	/**
	 * @return the aptoAcasalamento
	 */
	public boolean isAptoAcasalamento() {
		return aptoAcasalamento;
	}
	/**
	 * @param aptoAcasalamento the aptoAcasalamento to set
	 */
	public void setAptoAcasalamento(boolean aptoAcasalamento) {
		this.aptoAcasalamento = aptoAcasalamento;
	}
}
