package com.dyzwj.graph;


import java.util.*;

/**
 *
 *      Dijkstra算法：   求解单元点的最短路径问题，给定带权有向图G和源点v，求v到G中其他顶点的最短路径
 *    堆的改写
 */
public class Dijkstra {


    public static Map<Node,Integer> dijkstra(Node head){
        Map<Node,Integer> map = new HashMap<>();
        Set<Node> set = new HashSet<>();
        map.put(head,0);
        Node minNode = getMinNode(map,set);
        while (minNode != null){

            ArrayList<Edge> edges = minNode.edges;
            for (Edge edge : edges) {
                if(!map.containsKey(edge.to)){
                   map.put(edge.to,map.get(minNode) + edge.weight);
                }else{
                    map.put(edge.to,Math.min(map.get(edge.to),map.get(minNode) + edge.weight));
                }
            }
            set.add(minNode);
            minNode = getMinNode(map,set);

        }
        return map;
    }

    //找不在set中的权值最小的node
    private static Node getMinNode(Map<Node, Integer> map, Set<Node> set) {
        Set<Map.Entry<Node, Integer>> entries = map.entrySet();
        Node res = null;
        Integer min = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry : entries) {
            if(!set.contains(entry.getKey())){
                if(entry.getValue() < min){
                    res = entry.getKey();
                    min = entry.getValue();
                }
            }
        }
        return res;
    }
}
