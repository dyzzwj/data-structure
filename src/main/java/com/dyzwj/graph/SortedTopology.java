package com.dyzwj.graph;

import java.util.*;

/**
 * 拓扑排序
 *  要求： 有向图 且有入度为0的点 且没有环
 *
 *   删除入度为0的节点和与该节点相关的边
 *
 */
public class SortedTopology {


    //weight :from :to
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[][]{
                {1,5,2},{2,2,3},{3,2,4},{4,3,4},{5,4,1}
        };

        sortedTopology(GraphGenerator.createGraph(matrix)).forEach(System.out::println);

    }

    public static List<Node> sortedTopology(Graph graph){

        Queue<Node> zeroInQueue = new LinkedList<>();
        //节点对应的入度
        HashMap<Node, Integer> inMap = new HashMap<>();
        List<Node> result = new ArrayList<>();
        //找到入度为0 的节点
        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        while (!zeroInQueue.isEmpty()){
            Node poll = zeroInQueue.poll();
            result.add(poll);
            for (Node next : poll.nexts) {
                inMap.put(next,inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }

        }
        return result;
    }


}
