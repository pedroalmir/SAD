/**
 * 
 */
package com.pedroalmir.optimization.algorithm.base;

import java.util.Map;

import com.pedroalmir.optimization.model.algorithm.solution.KnapsackSolution;

/**
 * Knapsack problem solver interface
 * @author Pedro Almir
 */
interface KnapsackProblemSolver {
	/**
	 * Initialize the algorithm settings.
	 * @param settings
	 */
	void initAlgorithmSettings(Map<String, Object> settings);
	/**
	 * Parse the problem to specific representation.
	 * For example, ACO use graph representation.
	 */
	void parseTheProblemToSpecificRepresentation();
	/**
	 * Solve the knapsack problem
	 * @param problem
	 * @return the solution to the problem
	 */
	KnapsackSolution solveKnapsackProblem();
}
