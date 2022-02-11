package com.dyzwj.graph;

public class GraphGenerator {

    /**
     * matrix
     *  0: weight
     *  1: from
     *  2: to
     *
     *  directed: false-无向图   true有向图
     */
    public static Graph createGraph(Integer[][] matrix,boolean directed) {
        Graph graph = new Graph();
        //无向图
        if(!directed){
            Integer[][] newMatrix = new Integer[matrix.length * 2][3];
            for (int i = 0; i < matrix.length; i++) {
                newMatrix[i][0] = matrix[i][0];
                newMatrix[i][1] = matrix[i][1];
                newMatrix[i][2] = matrix[i][2];
                newMatrix[matrix.length + i][0] = matrix[i][0];
                newMatrix[matrix.length + i][1] = matrix[i][2];
                newMatrix[matrix.length + i][2] = matrix[i][1];
            }
            matrix = newMatrix;
            for (int i = 0; i < matrix.length; i++) {
                Integer[] ele = matrix[i];
                System.out.println();
                for (int j = 0; j < ele.length; j++) {
                    System.out.print(matrix[i][j] + "   ");
                }
            }

            System.out.println();
        }

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
