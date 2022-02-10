package com.dyzwj.graph;

import java.util.ArrayList;

public class Node {
	//点的标识
	public int value;
	//入度
	public int in;
	//出度
	public int out;
	//由当前节点出发到的点
	public ArrayList<Node> nexts;
	//当前节点为出发点的边
	public ArrayList<Edge> edges;

	public Node(int value) {
		this.value = value;
		in = 0;
		out = 0;
		nexts = new ArrayList<>();
		edges = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Node{" +
				"value=" + value +
				'}';
	}
}
