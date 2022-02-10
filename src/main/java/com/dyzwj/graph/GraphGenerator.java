package com.dyzwj.graph;

public class GraphGenerator {

    /**
     * matrix
     *  0: weight
     *  1: from
     *  2: to
     */
    public static Graph createGraph(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            int weight = matrix[i][0];
            int from  = matrix[i][1];
            int to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            fromNode.nexts.add(toNode);
            Edge edge = new Edge(weight,fromNode,toNode);
            graph.edges.add(edge);
            fromNode.edges.add(edge);
            //出度
            fromNode.out++;
            //入度
            toNode.in++;
        }
        return graph;
    }
}
