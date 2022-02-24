package com.dyzwj.unionfind;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;

import java.util.*;

public class UnionFind<V> {

    //k - ele, v - 代表元素
    private Map<Element<V>,Element<V>> parentMap = new HashMap<>();
    //k - v , v - ele
    private Map<V,Element<V>> valueMap = new HashMap<>();

    //k - 代表元素,v - 以k为代表元素的元素个数
    private Map<Element<V>,Integer> sizeMap = new HashMap<>();

    public UnionFind(List<V> list){
        for (V v : list) {
            Element<V> ele = new Element<>();
            parentMap.put(ele,ele);
            valueMap.put(v,ele);
            sizeMap.put(ele,1);
        }
    }

    //获取代表元素
    private Element<V> getHead(V v){
        Stack<Element<V>> stack = new Stack<>();
        Element<V> element = valueMap.get(v);
        while (element != parentMap.get(element)){
            stack.push(element);
            element = parentMap.get(element);
        }
        while (!stack.isEmpty()){
            parentMap.put(stack.pop(),element);
        }

        return element;
    }

    public void merge(V v1,V v2){
        //获取代表元素
        Element<V> ele1 = getHead(v1);
        Element<V> ele2 = getHead(v2);
        if(ele1 != ele2 && valueMap.containsKey(v1) && valueMap.containsKey(v2)){
            Integer size1 = sizeMap.get(ele1);
            Integer size2 = sizeMap.get(ele2);
            Element<V> ele = size1 > size2 ? ele2 : ele1;
            Element<V> max = ele == ele1 ? ele2 : ele1;
            parentMap.put(ele,max);
            sizeMap.remove(ele);
            sizeMap.put(max,sizeMap.get(max) + 1);
        }
    }

    public boolean isSameSet(V v1, V v2){
        //获取代表元素
        if(valueMap.containsKey(v1) && valueMap.containsKey(v2)){
            return getHead(v1) == getHead(v2);
        }
        return false;
    }


    static class Element<V>{
        V v;
    }


    public static void main(String[] args) {

        UnionFind<Integer> unionFind = new UnionFind<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(unionFind.isSameSet(1,2));

        unionFind.merge(1,2);
        System.out.println(unionFind.isSameSet(1,2));

        System.out.println(unionFind.isSameSet(1,3));

        unionFind.merge(2,3);
        System.out.println(unionFind.isSameSet(1,3));

    }





}
