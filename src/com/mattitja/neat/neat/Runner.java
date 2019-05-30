package com.mattitja.neat.neat;

import com.mattitja.neat.genome.Genome;

public class Runner {
	public static void main(String[] args) {
		System.out.println("Running NEAT.");

		Neat neat = new Neat(3, 3, 100);

		Genome g = neat.createEmptyGenome();
		System.out.println(g.getNodes().size());
	}
}
