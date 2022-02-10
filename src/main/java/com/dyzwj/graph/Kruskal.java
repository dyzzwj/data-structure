package com.dyzwj.graph;

import java.util.*;

/**
 *   此算法可以称为“加边法”，初始最小生成树边数为0，每迭代一次就选择一条满足条件的最小代价边，加入到最小生成树的边集合里。
 * 1. 把图中的所有边按代价从小到大排序；
 * 2. 把图中的n个顶点看成独立的n棵树组成的森林；
 * 3. 按权值从小到大选择边，所选的边连接的两个顶点from,to,应属于两颗不同的树，则成为最小生成树的一条边，并将这两颗树合并作为一颗树。
 * 4. 重复(3),直到所有顶点都在一颗树内或者有n-1条边为止。
 *
 *        并查集：判断from和to是否属于两颗不同的树
 */
public class Kruskal {


    static class KruskalComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }



    public static List<Edge> process(Graph graph){
        List<Edge> result = new ArrayList<>();
        UnionSet unionSet = new UnionSet(graph.nodes.values());
        PriorityQueue<Edge> queue = new PriorityQueue<>(new KruskalComparator());
        for (Edge edge : graph.edges) {
            queue.add(edge);
        }

        while (!queue.isEmpty()){
            Edge poll = queue.poll();
            if(!unionSet.isSameSet(poll.from,poll.to)){
                result.add(poll);
                unionSet.merge(poll.from, poll.to);
            }
        }
        return result;

    }


    //并查集
    static class UnionSet{
        //并查集
        Map<Node, List<Node>> set;

        public UnionSet(Collection<Node> nodes){
            set = new HashMap<>();
            for (Node node : nodes) {
                set.computeIfAbsent(node,(node1) -> {
                    List<Node> objects = new ArrayList<>();
                    objects.add(node1);
                    return objects;
                });
            }
        }

        public boolean isSameSet(Node node1,Node node2){
            return set.get(node1) == set.get(node2);
        }

        public void merge(Node from,Node to){
            List<Node> fromNodes = set.get(from);
            List<Node> toNodes = set.get(to);
            for (Node toNode : toNodes) {
                fromNodes.add(toNode);
                set.put(toNode,fromNodes);
            }
        }

    }








}






