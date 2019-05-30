package com.mattitja.neat.genes;

public class NodeGene extends Gene {

	private double x;
	private double y;

	public NodeGene(int innovationNumber) {
		super(innovationNumber);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean equals(Object other) {
		if (!(other instanceof NodeGene)) {
			return false;
		} else {
			return innovationNumber == ((NodeGene) other).getInnovationNumber();
		}
	}

	public int hashCode() {
		return innovationNumber;
	}
}
