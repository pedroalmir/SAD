/**
 * 
 */
package com.pedroalmir.optimization.model.domain;

import java.util.ArrayList;

import com.pedroalmir.optimization.model.domain.enun.CaracteristicaEnum;
import com.pedroalmir.optimization.model.domain.enun.GrupoContemporaneosEnum;

/**
 * @author Pedro Almir
 */
public class InputModel {
	
	/** */
	private String fileName;
	private String mimeType;
	private byte[] data;
	/** */
	private double percentualMachos;
	/** */
	private double percentualFemeas;
	/** */
	private int idadeAcasalamentoMachos;
	/** */
	private int idadeAcasalamentoFemeas;
	/** */
	private double proporcaoMachoFemea;
	/** */
	private double herdabilidade;
	/** */
	private ArrayList<GrupoContemporaneosEnum> grupos;
	/** */
	private CaracteristicaEnum caracteristica;
	
	/**
	 * 
	 */
	public InputModel() {
		this.grupos = new ArrayList<GrupoContemporaneosEnum>();
	}
	
	/**
	 * @param data
	 * @param percentualMachos
	 * @param percentualFemeas
	 * @param idadeAcasalamentoMachos
	 * @param idadeAcasalamentoFemeas
	 * @param proporcaoMachoFemea
	 * @param herdabilidade
	 * @param grupos
	 * @param caracteristica
	 */
	public InputModel(byte[] data, double percentualMachos,
			double percentualFemeas, int idadeAcasalamentoMachos,
			int idadeAcasalamentoFemeas, double proporcaoMachoFemea,
			double herdabilidade, ArrayList<GrupoContemporaneosEnum> grupos,
			CaracteristicaEnum caracteristica) {
		super();
		this.data = data;
		this.percentualMachos = percentualMachos;
		this.percentualFemeas = percentualFemeas;
		this.idadeAcasalamentoMachos = idadeAcasalamentoMachos;
		this.idadeAcasalamentoFemeas = idadeAcasalamentoFemeas;
		this.proporcaoMachoFemea = proporcaoMachoFemea;
		this.herdabilidade = herdabilidade;
		this.grupos = grupos;
		this.caracteristica = caracteristica;
	}
	
	/**
	 * @param grupo
	 */
	public void addGrupo(GrupoContemporaneosEnum grupo){
		this.grupos.add(grupo);
	}
	
	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
	/**
	 * @return the percentualMachos
	 */
	public double getPercentualMachos() {
		return percentualMachos;
	}
	/**
	 * @param percentualMachos the percentualMachos to set
	 */
	public void setPercentualMachos(double percentualMachos) {
		this.percentualMachos = percentualMachos;
	}
	/**
	 * @return the percentualFemeas
	 */
	public double getPercentualFemeas() {
		return percentualFemeas;
	}
	/**
	 * @param percentualFemeas the percentualFemeas to set
	 */
	public void setPercentualFemeas(double percentualFemeas) {
		this.percentualFemeas = percentualFemeas;
	}
	/**
	 * @return the idadeAcasalamentoMachos
	 */
	public int getIdadeAcasalamentoMachos() {
		return idadeAcasalamentoMachos;
	}
	/**
	 * @param idadeAcasalamentoMachos the idadeAcasalamentoMachos to set
	 */
	public void setIdadeAcasalamentoMachos(int idadeAcasalamentoMachos) {
		this.idadeAcasalamentoMachos = idadeAcasalamentoMachos;
	}
	/**
	 * @return the idadeAcasalamentoFemeas
	 */
	public int getIdadeAcasalamentoFemeas() {
		return idadeAcasalamentoFemeas;
	}
	/**
	 * @param idadeAcasalamentoFemeas the idadeAcasalamentoFemeas to set
	 */
	public void setIdadeAcasalamentoFemeas(int idadeAcasalamentoFemeas) {
		this.idadeAcasalamentoFemeas = idadeAcasalamentoFemeas;
	}
	/**
	 * @return the proporcaoMachoFemea
	 */
	public double getProporcaoMachoFemea() {
		return proporcaoMachoFemea;
	}
	/**
	 * @param proporcaoMachoFemea the proporcaoMachoFemea to set
	 */
	public void setProporcaoMachoFemea(double proporcaoMachoFemea) {
		this.proporcaoMachoFemea = proporcaoMachoFemea;
	}
	/**
	 * @return the herdabilidade
	 */
	public double getHerdabilidade() {
		return herdabilidade;
	}
	/**
	 * @param herdabilidade the herdabilidade to set
	 */
	public void setHerdabilidade(double herdabilidade) {
		this.herdabilidade = herdabilidade;
	}
	/**
	 * @return the grupos
	 */
	public ArrayList<GrupoContemporaneosEnum> getGrupos() {
		return grupos;
	}
	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(ArrayList<GrupoContemporaneosEnum> grupos) {
		this.grupos = grupos;
	}
	/**
	 * @return the caracteristica
	 */
	public CaracteristicaEnum getCaracteristica() {
		return caracteristica;
	}
	/**
	 * @param caracteristica the caracteristica to set
	 */
	public void setCaracteristica(CaracteristicaEnum caracteristica) {
		this.caracteristica = caracteristica;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InputModel [fileName=" + fileName + ", percentualMachos="
				+ percentualMachos + ", percentualFemeas=" + percentualFemeas
				+ ", idadeAcasalamentoMachos=" + idadeAcasalamentoMachos
				+ ", idadeAcasalamentoFemeas=" + idadeAcasalamentoFemeas
				+ ", proporcaoMachoFemea=" + proporcaoMachoFemea
				+ ", herdabilidade=" + herdabilidade + ", grupos=" + grupos
				+ ", caracteristica=" + caracteristica + "]";
	}
}
