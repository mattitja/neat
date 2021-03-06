package com.mattitja.neat.genes;

import com.mattitja.neat.neat.Neat;

public class ConnectionGene extends Gene {

	private NodeGene from;
	private NodeGene to;
	private double weight;
	private boolean enabled;

	public ConnectionGene(NodeGene from, NodeGene to) {
		this.from = from;
		this.to = to;
	}

	public NodeGene getFrom() {
		return from;
	}

	public void setFrom(NodeGene from) {
		this.from = from;
	}

	public NodeGene getTo() {
		return to;
	}

	public void setTo(NodeGene to) {
		this.to = to;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean equals(Object o) {
		if (!(o instanceof ConnectionGene)) {
			return false;
		}

		ConnectionGene other = (ConnectionGene) o;
		return other.getFrom().equals(from) && other.getTo().equals(to);
	}

	// assuring we always get NEW innovation numbers
	public int hashCode() {
		return from.getInnovationNumber() * Neat.MAX_NODES + to.getInnovationNumber();
	}

	public ConnectionGene copy(ConnectionGene original) {
		ConnectionGene copy = new ConnectionGene(original.from, original.to);
		copy.setEnabled(original.isEnabled());
		copy.setWeight(original.getWeight());
		return copy;
	}
}
