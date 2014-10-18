/**
 * 
 */
package com.pedroalmir.optimization.algorithm.genetic.gGA;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import jmetal.core.Algorithm;
import jmetal.core.Problem;
import jmetal.core.Solution;
import jmetal.core.SolutionSet;
import jmetal.metaheuristics.singleObjective.geneticAlgorithm.gGA;
import jmetal.operators.crossover.CrossoverFactory;
import jmetal.operators.mutation.MutationFactory;
import jmetal.operators.selection.SelectionFactory;
import jmetal.util.JMException;

import com.pedroalmir.optimization.model.algorithm.solution.AnimalSelectionSolution;
import com.pedroalmir.optimization.model.domain.Animal;
import com.pedroalmir.optimization.model.domain.InputModel;

/**
 * @author Pedro Almir
 *
 */
public class GGAAlgorithm {

	/** InputModel */
	private InputModel model;
	/** Lista de animais aptos a seleção */
	private ArrayList<Animal> animais;
	/** */
	private int qntMaxMachos, qntMaxFemeas;
	/** Decimal format */
	private DecimalFormat fmt = new DecimalFormat("0.00");

	/**
	 * @param model
	 * @param animaisAptos
	 */
	public GGAAlgorithm(InputModel model, ArrayList<Animal> animaisAptos, int qntMaxMachos, int qntMaxFemeas) {
		this.model = model;
		this.animais = animaisAptos;
		
		this.qntMaxMachos = qntMaxMachos;
		this.qntMaxFemeas = qntMaxFemeas;
	}

	/**
	 * InitAlgorithmSettings
	 */
	private Algorithm initAlgorithmSettings() {
		try {
			/* The problem to solve */
			double intensidadeSelecaoTotal = this.model.getIntensidadeSelecaoMachos() + this.model.getIntensidadeSelecaoFemeas();
			Problem problem = new AnimalSelectionProblem(this.animais, intensidadeSelecaoTotal, this.model.getHerdabilidade(), 
					this.model.getDesvioPadraoCaracteristica(), this.qntMaxMachos, this.qntMaxFemeas);
			Algorithm algorithm = new gGA(problem);
			
			/* Algorithm parameters */
			algorithm.setInputParameter("populationSize", 100);
			algorithm.setInputParameter("maxEvaluations", 25000);

			/* Add the operators to the algorithm */
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			
			parameters.put("probability", 0.9);
			parameters.put("distributionIndex", 20.0);
			algorithm.addOperator("crossover", CrossoverFactory.getCrossoverOperator("SinglePointCrossover", parameters));
			
			parameters = new HashMap<String, Object>();
			parameters.put("probability", 0.1);
			parameters.put("distributionIndex", 20.0);
			algorithm.addOperator("mutation", MutationFactory.getMutationOperator("BitFlipMutation", parameters));
			
			algorithm.addOperator("selection", SelectionFactory.getSelectionOperator("BinaryTournament", null));
			return algorithm;
		} catch (JMException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param algorithm
	 * @return 
	 */
	public ArrayList<AnimalSelectionSolution> solveProblem() {
		try {
			/* InitAlgorithm */
			Algorithm algorithm = this.initAlgorithmSettings();
			
			/* Execute the Algorithm */
			SolutionSet solutionSet = algorithm.execute();
			Iterator<Solution> iterator = solutionSet.iterator();
			
			AnimalSelectionSolution animalSelectionSolution = null;
			ArrayList<AnimalSelectionSolution> results = new ArrayList<AnimalSelectionSolution>();
			
			while (iterator.hasNext()) {
				Solution solution = (Solution) iterator.next();
				animalSelectionSolution = new AnimalSelectionSolution(formatResult(this.fmt,(-1 * solution.getObjective(0))));
				
				/* Get list of items selected */
				for(int i = 0; i < this.animais.size(); i++){
					if(solution.getDecisionVariables()[i].toString().trim().equals("1")){
						animalSelectionSolution.addAnimalSelecionado(this.animais.get(i));
					}
				}
				System.out.println(animalSelectionSolution);
				results.add(animalSelectionSolution);
			}
			
			Collections.sort(results, new Comparator<AnimalSelectionSolution>() {
				@Override
				public int compare(AnimalSelectionSolution o1, AnimalSelectionSolution o2) {
					return Double.valueOf(o2.getGanhoGenetico()).compareTo(Double.valueOf(o1.getGanhoGenetico()));
				}
			});
			
			return results;
		} catch (JMException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * @param fmt
	 * @param value
	 * @return
	 */
	private static double formatResult(DecimalFormat fmt, double value){
		return Double.valueOf(fmt.format(value).replaceAll(",", "."));
	}
}
