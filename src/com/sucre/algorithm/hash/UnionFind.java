package com.sucre.algorithm.hash;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集的实现，对递归的理解更加深入了一些
 */
public class UnionFind {
    public static class Node{}
    private HashMap<Node, Node> fatherMap = new HashMap<>();
    private HashMap<Node, Integer> sizeMap = new HashMap<>();

    /**
     * 给定一些节点的集合，将其初始化成各个节点的并查集
     * @param list 节点的集合
     */
    public void initSet(List<Node> list){
        for (Node node : list) {
            fatherMap.put(node, node);
            sizeMap.put(node, 1);
        }
    }

    /**
     * 查找头结点的方法，并对路径上的节点进行了优化
     * @param node
     * @return
     */
    public Node findHead(Node node){
        Node father = fatherMap.get(node);
        if (father != node){
            father = findHead(father);
        }
        fatherMap.put(node, father);//执行到这一步，说明father是头节点，而每一次递归的node是从最开始往上的node集合，这个操作等于把
                                    //路径上所有的节点都挂到了头上
        return father;
    }

    /**
     * 是否是同一个集合
     * @param a a借点
     * @param b b节点
     * @return true 或者 false
     */
    public boolean isSameSet(Node a, Node b){
        return findHead(a) == findHead(b);
    }

    /**
     * 合并两个集合
     * @param a A元素
     * @param b B元素
     */
    public void union(Node a, Node b){
        Node aHead = findHead(a);
        Node bHead = findHead(b);
        int aSize = sizeMap.get(aHead);
        int bSize = sizeMap.get(bHead);
        if (aHead != bHead){
            if (aSize >= bSize){
                fatherMap.put(bHead, aHead);
                sizeMap.put(aHead, aSize + bSize);
            }else {
                fatherMap.put(aHead, bHead);
                sizeMap.put(bHead, aSize + bSize);
            }
        }
    }
}
