package com.mattitja.neat.genome;

import com.mattitja.neat.datatypes.RandomHashSet;
import com.mattitja.neat.genes.ConnectionGene;
import com.mattitja.neat.genes.NodeGene;
import com.mattitja.neat.neat.Neat;

public class Genome {

	private RandomHashSet<ConnectionGene> connections;
	private RandomHashSet<NodeGene> nodes;

	private Neat neat;

	public Genome(Neat neat) {
		connections = new RandomHashSet<>();
		nodes = new RandomHashSet<>();
		this.neat = neat;
	}

	public double distance(Genome other) {
		return 0;
	}

	public Genome crossOver(Genome g1, Genome g2) {
		return null;
	}

	public void mutate() {

	}

	public RandomHashSet<ConnectionGene> getConnections() {
		return connections;
	}

	public RandomHashSet<NodeGene> getNodes() {
		return nodes;
	}
}
