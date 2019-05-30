package com.mattitja.neat.neat;

import com.mattitja.neat.genes.ConnectionGene;
import com.mattitja.neat.genes.NodeGene;
import com.mattitja.neat.genome.Genome;

import java.util.ArrayList;
import java.util.HashMap;

public class Neat {

	public static int MAX_NODES = (int) Math.pow(2, 20);

	private HashMap<ConnectionGene, ConnectionGene> allConnections;
	private ArrayList<NodeGene> allNodes;

	private int clients;

	private int inputSize;
	private int outputSize;

	public Neat(int inputSize, int outputSize, int clients) {
		allConnections = new HashMap<>();
		allNodes = new ArrayList<>();

		reset(inputSize, outputSize, clients);
	}

	public void reset(int inputSize, int outputSize, int clients) {
		this.clients = clients;
		this.inputSize = inputSize;
		this.outputSize = outputSize;

		createInitialNodes(inputSize, 0.1);
		createInitialNodes(outputSize, 0.9);
	}

	private void createInitialNodes(int size, double x) {
		for (int i = 0; i < size; i++) {
			NodeGene node = createNode();
			node.setX(x);
			node.setY((i + 1) / (double) (size + 1));
		}
	}

	private NodeGene createNode() {
		NodeGene n = new NodeGene(allNodes.size());
		allNodes.add(n);
		return n;
	}

	public NodeGene createOrGetNode(int innovationNumber) {
		NodeGene node;
		try {
			node = allNodes.get(innovationNumber);
		} catch (IndexOutOfBoundsException e) {
			node = createNode();
		}
		return node;
	}

	public Genome createEmptyGenome() {
		Genome genome = new Genome(this);
		for (int i = 0; i < inputSize + outputSize; i++) {
			genome.getNodes().add(createNode());
		}
		return genome;
	}

	public ConnectionGene createNewOrGet(NodeGene from, NodeGene to) {
		ConnectionGene connectionGene = new ConnectionGene(from, to);

		if (allConnections.containsKey(connectionGene)) {
			connectionGene.setInnovationNumber(allConnections.get(connectionGene).getInnovationNumber());
		} else {
			connectionGene.setInnovationNumber(allConnections.size());
			allConnections.put(connectionGene, connectionGene);
		}
		return connectionGene;
	}

}
