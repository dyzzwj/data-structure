package com.dyzwj.graph;


/**
 * 边
 */
public class Edge {
	//权重
	public int weight;
	public Node from;
	public Node to;

	public Edge(int weight, Node from, Node to) {
		this.weight = weight;
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return "Edge{" +
				"weight=" + weight +
				", from=" + from +
				", to=" + to +
				'}';
	}
}
