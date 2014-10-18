/**
 * 
 */
package com.pedroalmir.optimization.model.algorithm.solution;

import java.util.ArrayList;

import com.pedroalmir.optimization.model.algorithm.problem.Item;

/**
 * This class represents a solution for knapsack problem.
 * @author Pedro Almir
 */
public class KnapsackSolution {
	private ArrayList<Item> selectedItems;
	private double fitness;
	private double accumulatedWeight;
	
	/**
	 * @param selectedItems
	 * @param fitness
	 */
	public KnapsackSolution(ArrayList<Item> selectedItems, double fitness) {
		super();
		this.selectedItems = selectedItems;
		this.fitness = fitness;
	}
	
	/**
	 * Default constructor
	 */
	public KnapsackSolution() {
		this.selectedItems = new ArrayList<Item>();
	}
	
	/**
	 * @param item
	 */
	public void addItem(Item item){
		this.selectedItems.add(item);
	}
	
	/**
	 * @param auxSolution
	 */
	public void copy(KnapsackSolution auxSolution) {
		this.fitness = auxSolution.getFitness();
		this.selectedItems = new ArrayList<Item>(auxSolution.getSelectedItems());
	}
	
	/**
	 * Clear
	 */
	public void clear() {
		this.fitness = 0.0;
		this.selectedItems.clear();
	}
	
	/**
	 * @return the selectedItems
	 */
	public ArrayList<Item> getSelectedItems() {
		return selectedItems;
	}
	/**
	 * @param selectedItems the selectedItems to set
	 */
	public void setSelectedItems(ArrayList<Item> selectedItems) {
		this.selectedItems = selectedItems;
	}
	/**
	 * @return the fitness
	 */
	public double getFitness() {
		return fitness;
	}
	/**
	 * @param fitness the fitness to set
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		double accumulatedWeight = 0.0;
		for(Item item : this.selectedItems){
			accumulatedWeight += item.getWeight();
		}
		this.accumulatedWeight = accumulatedWeight;
		return "KnapsackSolution [fitness=" + fitness + ", accumulatedWeight=" + accumulatedWeight + ", selectedItems=" + selectedItems + "]";
	}

	/**
	 * @return the accumulatedWeight
	 */
	public double getAccumulatedWeight() {
		return accumulatedWeight;
	}

	/**
	 * @param accumulatedWeight the accumulatedWeight to set
	 */
	public void setAccumulatedWeight(double accumulatedWeight) {
		this.accumulatedWeight = accumulatedWeight;
	}

}
