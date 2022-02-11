package com.dyzwj.graph;


import java.util.*;

/**
 *   最小生成树
 * p算法：要求无向图
 *
 * 此算法可以称为“加点法”，每次迭代选择代价最小的边对应的点，加入到最小生成树中。算法从某一个顶点s开始，逐渐长大覆盖整个连通网的所有顶点。
 *
 * 1、图的所有顶点集合为V；初始令集合u={s},v=V−uu={s},v=V−u;
 * 2、在两个集合u,vu,v能够组成的边中，选择一条代价最小的边(u0,v0)(u0,v0)，加入到最小生成树中，并把v0v0并入到集合u中。
 * 3、重复上述步骤，直到最小生成树有n-1条边或者n个顶点为止。
 */

public class Prim {



    static class EdgeComparator implements Comparator<Edge>{


        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static List<Edge> prim(Graph graph){
        Set<Node> set = new HashSet<>();
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        List<Edge> result = new ArrayList<>();
        for (Node node : graph.nodes.values()) {
            if(!set.contains(node)){
                set.add(node);
                for (Edge edge : node.edges) {
                    //把从该节点出发的边都加到小根堆中
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()){
                    //权值最小的边
                    Edge poll = priorityQueue.poll();
                    Node to = poll.to;
                    if(!set.contains(to)){
                        set.add(to);
                        result.add(poll);
                        for (Edge edge : to.edges) {
                            priorityQueue.add(edge);
                        }
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Integer[][] martix = new Integer[][]{
                {2,1,2},{1,2,4},{4,1,3},{3,1,4},{5,3,5},{17,4,5}
        };
        prim(GraphGenerator.createGraph(martix,false)).forEach(System.out::println);


    }

}
