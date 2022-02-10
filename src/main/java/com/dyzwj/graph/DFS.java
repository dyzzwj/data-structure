package com.dyzwj.graph;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 深度优先遍历:
 *   假设初始状态是图中所有顶点均未被访问，则从某个顶点v出发，首先访问该顶点，然后依次从它的各个未被访问的邻接点出发深度优先搜索遍历图，直至图中所有和v有路径相通的顶点都被访问到。
 *   若此时尚有其他顶点未被访问到，则另选一个未被访问的顶点作起始点，重复上述过程，直至图中所有顶点都被访问到为止
 *
 */
public class DFS {


    public static void dfs(Node node){
        Stack<Node> stack = new Stack();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                if(!set.contains(next)){
                    stack.push(pop);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }

            }

        }

    }

}
