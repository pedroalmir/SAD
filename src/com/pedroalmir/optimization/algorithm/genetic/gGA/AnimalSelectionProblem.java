/**
 * 
 */
package com.pedroalmir.optimization.algorithm.genetic.gGA;

import java.util.ArrayList;
import java.util.Arrays;

import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.encodings.solutionType.IntSolutionType;
import jmetal.util.JMException;

import com.pedroalmir.optimization.model.domain.Animal;
import com.pedroalmir.optimization.model.domain.enuns.SexoEnum;

/**
 * @author Pedro Almir
 *
 */
public class AnimalSelectionProblem extends Problem{
	
	/** Serial version UID */
	private static final long serialVersionUID = 7098486843573423568L;
	
	/** Somat�rio da intensidade de sele��o para machos e f�meas */
	private double intensidadeSelecaoTotal;
	/** Valor da herdabilidade */
	private double herdabilidade;
	/** Lista de animais aptos a sele��o */
	private ArrayList<Animal> animais;
	/** Desvio padr�o da caracter�stica */
	private double desvioPadraoCaracteristica;
	/** Restri��es */
	private int qntMaxMachos;
	private int qntMaxFemeas;

	
	/**
	 * @param animais
	 * @param intensidadeSelecaoTotal
	 * @param herdabilidade
	 * @param desvioPadraoCaracteristica
	 * @param qntMaxMachos
	 * @param qntMaxFemeas
	 */
	public AnimalSelectionProblem(ArrayList<Animal> animais, double intensidadeSelecaoTotal, double herdabilidade, 
			double desvioPadraoCaracteristica, int qntMaxMachos, int qntMaxFemeas) {
		this.problemName_ = "Sele��o de animais para acasalamento";
		
		/* Domain variables */
		this.animais = animais;
		this.herdabilidade = herdabilidade;
		this.intensidadeSelecaoTotal = intensidadeSelecaoTotal;
		this.desvioPadraoCaracteristica = desvioPadraoCaracteristica;
		
		/* Restri��es */
		this.qntMaxMachos = qntMaxMachos;
		this.qntMaxFemeas = qntMaxFemeas;
		
		/* List of Variables */
		this.numberOfVariables_ = this.animais.size();
		/* The number of objectives: Gain */
		this.numberOfObjectives_ = 1;
		/* The number of constraints: knapsack restriction */
		this.numberOfConstraints_ = 1;
		
		/* Define a binary solution */
		this.lowerLimit_ = new double[numberOfVariables_];
		this.upperLimit_ = new double[numberOfVariables_];

		for (int i = 0; i < this.numberOfVariables_; i++) {
			this.lowerLimit_[i] = 0;
			this.upperLimit_[i] = 1;
		}
		this.solutionType_ = new IntSolutionType(this);
	}

	@Override
	public void evaluate(Solution solution) throws JMException {
		double x[] = new double[this.numberOfVariables_];
		
		int qntMachos = 0, qntFemeas = 0;
		int somatorioIdadeMachos = 0, somatorioIdadeFemeas = 0;
		
		for(int i = 0; i < this.numberOfVariables_; i++){
			x[i] = solution.getDecisionVariables()[i].getValue();
			if(x[i] == 1){
				if(this.animais.get(i).getSexo().equals(SexoEnum.MACHO)){
					somatorioIdadeMachos += this.animais.get(i).getIdadeAtualAnos();
					qntMachos++;
				}else{
					somatorioIdadeFemeas += this.animais.get(i).getIdadeAtualAnos();
					qntFemeas++;
				}
			}
		}
		
		//System.out.println("QntMachos: " + qntMachos + ", QntFemeas: " + qntFemeas);
		if((qntMachos <= this.qntMaxMachos) && (qntFemeas <= this.qntMaxFemeas)){
			double somatorioMediasIdade = (somatorioIdadeMachos/qntMachos) + (somatorioIdadeFemeas/qntFemeas);
			double ganhoGenetico = (this.intensidadeSelecaoTotal/somatorioMediasIdade) * this.herdabilidade * this.desvioPadraoCaracteristica;
			
			System.out.println("           Solu��o Gerada: " + Arrays.toString(x));
			System.out.println("Intensidade Sele��o Total: " + this.intensidadeSelecaoTotal);
			System.out.println("            Herdabilidade: " + this.herdabilidade);
			System.out.println("            Desvio Padr�o: " + this.desvioPadraoCaracteristica);
			System.out.println("        Quantidade Machos: " + qntMachos);
			System.out.println("        Quantidade F�meas: " + qntFemeas);
			System.out.println("           Ganho Gen�tico: " + ganhoGenetico + "\n");
			
			solution.setObjective(0, -1 * ganhoGenetico);
		}else{
			solution.setObjective(0, 0.0);
		}
	}
}
