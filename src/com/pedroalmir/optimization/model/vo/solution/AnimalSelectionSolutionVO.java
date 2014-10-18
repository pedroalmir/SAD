/**
 * 
 */
package com.pedroalmir.optimization.model.vo.solution;

import java.util.ArrayList;

import com.pedroalmir.optimization.model.domain.Animal;
import com.pedroalmir.optimization.model.domain.enuns.SexoEnum;

/**
 * @author Pedro Almir
 *
 */
public class AnimalSelectionSolutionVO {
	
	/** */
	private final int id;
	private final double ganhoGenetico;
	/** */
	private final ArrayList<Animal> animaisSelecionados;
	private final String machosSelecionados;
	private final String femeasSelecionados;
	
	/**
	 * @param ganhoGenetico
	 */
	public AnimalSelectionSolutionVO(int id, double ganhoGenetico, ArrayList<Animal> animaisSelecionados) {
		this.id = id;
		this.ganhoGenetico = ganhoGenetico * 1000;
		this.animaisSelecionados = animaisSelecionados;
		String machosSelecionados = "", femeasSelecionados = "";
		for(Animal animal : animaisSelecionados){
			if(animal.getSexo().equals(SexoEnum.MACHO)){
				machosSelecionados = machosSelecionados.concat(animal.getIdAnimal() + ", ");
			}else{
				femeasSelecionados = femeasSelecionados.concat(animal.getIdAnimal() + ", ");
			}
		}
		
		this.machosSelecionados = machosSelecionados.substring(0, machosSelecionados.length()-2);
		this.femeasSelecionados = femeasSelecionados.substring(0, femeasSelecionados.length()-2);
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
	 * @return the animaisSelecionados
	 */
	public ArrayList<Animal> getAnimaisSelecionados() {
		return animaisSelecionados;
	}

	/**
	 * @return the machosSelecionados
	 */
	public String getMachosSelecionados() {
		return machosSelecionados;
	}

	/**
	 * @return the femeasSelecionados
	 */
	public String getFemeasSelecionados() {
		return femeasSelecionados;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AnimalSelectionSolutionVO [ganhoGenetico=" + ganhoGenetico
				+ ", machosSelecionados=" + machosSelecionados
				+ ", femeasSelecionados=" + femeasSelecionados + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
