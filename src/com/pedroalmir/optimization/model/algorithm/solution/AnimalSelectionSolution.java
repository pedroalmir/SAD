/**
 * 
 */
package com.pedroalmir.optimization.model.algorithm.solution;

import java.util.ArrayList;

import com.pedroalmir.optimization.model.domain.Animal;

/**
 * @author Pedro Almir
 *
 */
public class AnimalSelectionSolution {
	
	/** */
	private double ganhoGenetico;
	/** */
	private ArrayList<Animal> animaisSelecionados;
	
	/**
	 * @param ganhoGenetico
	 */
	public AnimalSelectionSolution(double ganhoGenetico) {
		this.ganhoGenetico = ganhoGenetico;
		this.animaisSelecionados = new ArrayList<Animal>();
	}
	
	/**
	 * @param animalSelecionado
	 */
	public void addAnimalSelecionado(Animal animalSelecionado){
		this.animaisSelecionados.add(animalSelecionado);
	}
	
	/**
	 * @return the ganhoGenetico
	 */
	public double getGanhoGenetico() {
		return ganhoGenetico;
	}
	/**
	 * @param ganhoGenetico the ganhoGenetico to set
	 */
	public void setGanhoGenetico(double ganhoGenetico) {
		this.ganhoGenetico = ganhoGenetico;
	}
	/**
	 * @return the animaisSelecionados
	 */
	public ArrayList<Animal> getAnimaisSelecionados() {
		return animaisSelecionados;
	}
	/**
	 * @param animaisSelecionados the animaisSelecionados to set
	 */
	public void setAnimaisSelecionados(ArrayList<Animal> animaisSelecionados) {
		this.animaisSelecionados = animaisSelecionados;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnimalSelectionSolution [ganhoGenetico=" + ganhoGenetico + ", animaisSelecionados=" + animaisSelecionados + "]";
	}
}
