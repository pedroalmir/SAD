/**
 * 
 */
package com.pedroalmir.optimization.model.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.pedroalmir.optimization.model.domain.enun.CaracteristicaEnum;
import com.pedroalmir.optimization.model.domain.enun.GrupoContemporaneosEnum;
import com.pedroalmir.optimization.model.domain.enuns.SexoEnum;

/**
 * @author Pedro Almir
 */
public class InputModel {
	
	/* CAMPOS INFORMADOS PELOS USUÁRIOS */
	/** Arquivo com os dados dos animais */
	private String fileName;
	private String mimeType;
	private byte[] data;
	/** Percentual de seleção dos machos */
	private double percentualMachos;
	/** Percentual de seleção das fêmeas */
	private double percentualFemeas;
	/** Idade mínima para acasalamento dos machos */
	private int idadeAcasalamentoMachos;
	/** Idade mínima para acasalamento das fêmeas */
	private int idadeAcasalamentoFemeas;
	/** Proporção de machos para fêmeas */
	private double proporcaoMachoFemea;
	/** Valor da herdabilidade */
	private double herdabilidade;
	
	/* CAMPOS ESTATICOS */
	/** Grupos de Contemporaneos: Ano da Coleta e Sexo */
	private ArrayList<GrupoContemporaneosEnum> grupos;
	/** Característica avaliada: Peso */
	private CaracteristicaEnum caracteristica;
	
	/* CAMPOS CALCULADOS */
	/** Média da característica */
	private double mediaCaracteristica;
	/** Desvio padrão da característica (peso), levando em
	 * consideração apenas os animais aptos a seleção. */
	private double desvioPadraoCaracteristica;
	/** Intensidade de seleção machos e fêmeas */
	private double intensidadeSelecaoMachos;
	private double intensidadeSelecaoFemeas;
	
	/**
	 * Default constructor 
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
	 * @param percentual
	 */
	public void calcIntensidadeSelecao(double percentual, SexoEnum sexo){
		if(sexo.equals(SexoEnum.MACHO)){
			Double value = this.getTabelaIntensidadeSelecao().get(percentual);
			if(value == null){
				Double anteriorKey = this.getTabelaIntensidadeSelecao().get(0.0001);
				for(Double key : this.getTabelaIntensidadeSelecao().keySet()){
					if(key > percentual){
						if(Math.abs(this.getTabelaIntensidadeSelecao().get(key) - percentual) <= Math.abs(this.getTabelaIntensidadeSelecao().get(anteriorKey) - percentual)){
							this.intensidadeSelecaoMachos = this.getTabelaIntensidadeSelecao().get(key).doubleValue();
							break;
						}else{
							this.intensidadeSelecaoMachos = this.getTabelaIntensidadeSelecao().get(anteriorKey).doubleValue();
							break;
						}
					}
					anteriorKey = key;
				}
			}
		}else{
			Double value = this.getTabelaIntensidadeSelecao().get(percentual);
			if(value == null){
				Double anteriorKey = this.getTabelaIntensidadeSelecao().get(0.0001);
				for(Double key : this.getTabelaIntensidadeSelecao().keySet()){
					if(key > percentual){
						if(Math.abs(this.getTabelaIntensidadeSelecao().get(key) - percentual) <= Math.abs(this.getTabelaIntensidadeSelecao().get(anteriorKey) - percentual)){
							this.intensidadeSelecaoFemeas = this.getTabelaIntensidadeSelecao().get(key).doubleValue();
							break;
						}else{
							this.intensidadeSelecaoFemeas = this.getTabelaIntensidadeSelecao().get(anteriorKey).doubleValue();
							break;
						}
					}
					anteriorKey = key;
				}
			}
		}
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

	/**
	 * @return
	 */
	public double getDesvioPadraoCaracteristica() {
		return desvioPadraoCaracteristica;
	}

	/**
	 * @param desvioPadraoCaracteristica
	 */
	public void setDesvioPadraoCaracteristica(double desvioPadraoCaracteristica) {
		this.desvioPadraoCaracteristica = desvioPadraoCaracteristica;
	}

	/**
	 * @return
	 */
	public double getMediaCaracteristica() {
		return mediaCaracteristica;
	}

	/**
	 * @param mediaCaracteristica
	 */
	public void setMediaCaracteristica(double mediaCaracteristica) {
		this.mediaCaracteristica = mediaCaracteristica;
	}
	
	/**
	 * @return tabela de intensidade de seleção para machos e fêmeas
	 */
	private LinkedHashMap<Double, Double> getTabelaIntensidadeSelecao(){
		LinkedHashMap<Double, Double> tabela = new LinkedHashMap<Double, Double>();
		tabela.put(0.0001, 3.96);
		tabela.put(0.0002, 3.79);
		tabela.put(0.0003, 3.687);
		tabela.put(0.0004, 3.613);
		tabela.put(0.0005, 3.554);
		tabela.put(0.0006, 3.507);
		tabela.put(0.0007, 3.464);
		tabela.put(0.0008, 3.429);
		tabela.put(0.0009, 3.397);
		tabela.put(0.0010, 3.367);
		tabela.put(0.0012, 3.317);
		tabela.put(0.0014, 3.273);
		tabela.put(0.0016, 3.234);
		tabela.put(0.0018, 3.201);
		tabela.put(0.0020, 3.17);
		tabela.put(0.0022, 3.142);
		tabela.put(0.0024, 3.117);
		tabela.put(0.0026, 3.093);
		tabela.put(0.0028, 3.07);
		tabela.put(0.0030, 3.05);
		tabela.put(0.0032, 3.03);
		tabela.put(0.0034, 3.012);
		tabela.put(0.0036, 2.994);
		tabela.put(0.0038, 2.978);
		tabela.put(0.0040, 2.962);
		tabela.put(0.0042, 2.947);
		tabela.put(0.0044, 2.032);
		tabela.put(0.0046, 2.918);
		tabela.put(0.0048, 2.905);
		tabela.put(0.0050, 2.892);
		tabela.put(0.0055, 2.862);
		tabela.put(0.0060, 2.834);
		tabela.put(0.0065, 2.808);
		tabela.put(0.0070, 2.784);
		tabela.put(0.0075, 2.761);
		tabela.put(0.0080, 2.74);
		tabela.put(0.0085, 2.72);
		tabela.put(0.0090, 2.701);
		tabela.put(0.0095, 2.683);
		tabela.put(0.0100, 2.665);
		tabela.put(0.0120, 2.603);
		tabela.put(0.0140, 2.549);
		tabela.put(0.0160, 2.502);
		tabela.put(0.0180, 2.459);
		tabela.put(0.0200, 2.421);
		tabela.put(0.0220, 2.386);
		tabela.put(0.0240, 2.353);
		tabela.put(0.0260, 2.323);
		tabela.put(0.0280, 2.295);
		tabela.put(0.0300, 2.268);
		tabela.put(0.0320, 2.243);
		tabela.put(0.0340, 2.219);
		tabela.put(0.0360, 2.197);
		tabela.put(0.0380, 2.175);
		tabela.put(0.0400, 2.154);
		tabela.put(0.0420, 2.135);
		tabela.put(0.0440, 2.116);
		tabela.put(0.0460, 2.097);
		tabela.put(0.0480, 2.08);
		tabela.put(0.0500, 2.063);
		tabela.put(0.0550, 2.023);
		tabela.put(0.0600, 1.985);
		tabela.put(0.0650, 1.951);
		tabela.put(0.0700, 1.918);
		tabela.put(0.0750, 1.887);
		tabela.put(0.0800, 1.858);
		tabela.put(0.0850, 1.831);
		tabela.put(0.0900, 1.804);
		tabela.put(0.0950, 1.779);
		tabela.put(0.1000, 1.755);
		tabela.put(0.1100, 1.709);
		tabela.put(0.1200, 1.667);
		tabela.put(0.1300, 1.627);
		tabela.put(0.1400, 1.59);
		tabela.put(0.1500, 1.555);
		tabela.put(0.1600, 1.521);
		tabela.put(0.1700, 1.489);
		tabela.put(0.1800, 1.458);
		tabela.put(0.1900, 1.428);
		tabela.put(0.2000, 1.4);
		tabela.put(0.2100, 1.372);
		tabela.put(0.2200, 1.346);
		tabela.put(0.2300, 1.32);
		tabela.put(0.2400, 1.295);
		tabela.put(0.2500, 1.271);
		tabela.put(0.2600, 1.248);
		tabela.put(0.2700, 1.225);
		tabela.put(0.2800, 1.202);
		tabela.put(0.2900, 1.18);
		tabela.put(0.3000, 1.159);
		tabela.put(0.3100, 1.138);
		tabela.put(0.3200, 1.118);
		tabela.put(0.3300, 1.097);
		tabela.put(0.3400, 1.078);
		tabela.put(0.3500, 1.058);
		tabela.put(0.3600, 1.039);
		tabela.put(0.3700, 1.02);
		tabela.put(0.3800, 1.002);
		tabela.put(0.3900, 0.984);
		tabela.put(0.4000, 0.966);
		tabela.put(0.4100, 0.948);
		tabela.put(0.4200, 0.931);
		tabela.put(0.4300, 0.913);
		tabela.put(0.4400, 0.896);
		tabela.put(0.4500, 0.88);
		tabela.put(0.4600, 0.863);
		tabela.put(0.4700, 0.846);
		tabela.put(0.4800, 0.83);
		tabela.put(0.4900, 0.814);
		tabela.put(0.5000, 0.798);
		tabela.put(0.5100, 0.782078431372549);
		tabela.put(0.5200, 0.766153846153846);
		tabela.put(0.5300, 0.75022641509434);
		tabela.put(0.5400, 0.735148148148148);
		tabela.put(0.5500, 0.72);
		tabela.put(0.5600, 0.704);
		tabela.put(0.5700, 0.688754385964912);
		tabela.put(0.5800, 0.674172413793103);
		tabela.put(0.5900, 0.658779661016949);
		tabela.put(0.6000, 0.644);
		tabela.put(0.6100, 0.629114754098361);
		tabela.put(0.6200, 0.614129032258064);
		tabela.put(0.6300, 0.599047619047619);
		tabela.put(0.6400, 0.5844375);
		tabela.put(0.6500, 0.569692307692308);
		tabela.put(0.6600, 0.555333333333334);
		tabela.put(0.6700, 0.540313432835821);
		tabela.put(0.6800, 0.526117647058824);
		tabela.put(0.6900, 0.511275362318841);
		tabela.put(0.7000, 0.496714285714286);
		tabela.put(0.7100, 0.481971830985916);
		tabela.put(0.7200, 0.467444444444444);
		tabela.put(0.7300, 0.453082191780822);
		tabela.put(0.7400, 0.438486486486486);
		tabela.put(0.7500, 0.423666666666667);
		tabela.put(0.7600, 0.408947368421053);
		tabela.put(0.7700, 0.394285714285714);
		tabela.put(0.7800, 0.379641025641026);
		tabela.put(0.7900, 0.364708860759494);
		tabela.put(0.8000, 0.35);
		tabela.put(0.8100, 0.334962962962963);
		tabela.put(0.8200, 0.320048780487805);
		tabela.put(0.8300, 0.304975903614458);
		tabela.put(0.8400, 0.289714285714286);
		tabela.put(0.8500, 0.274411764705882);
		tabela.put(0.8600, 0.258837209302326);
		tabela.put(0.8700, 0.243114942528736);
		tabela.put(0.8800, 0.227318181818182);
		tabela.put(0.8900, 0.211224719101124);
		tabela.put(0.9000, 0.195);
		tabela.put(0.9100, 0.178417582417582);
		tabela.put(0.9200, 0.161565217391304);
		tabela.put(0.9300, 0.14436559139785);
		tabela.put(0.9400, 0.126702127659575);
		tabela.put(0.9500, 0.106947368421053);
		tabela.put(0.9600, 0.0889583333333334);
		tabela.put(0.9700, 0.0693711340206186);
		tabela.put(0.9800, 0.0486938775510205);
		tabela.put(0.9900, 0.0262929292929293);
		tabela.put(1.0000, 0.0);
		return tabela;
	}

	/**
	 * @return the intensidadeSelecaoMachos
	 */
	public double getIntensidadeSelecaoMachos() {
		return intensidadeSelecaoMachos;
	}

	/**
	 * @return the intensidadeSelecaoFemeas
	 */
	public double getIntensidadeSelecaoFemeas() {
		return intensidadeSelecaoFemeas;
	}
}
