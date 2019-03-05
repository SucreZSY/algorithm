package com.sucre.algorithm.preTree;

/**
 * 前缀树的实现
 */
@SuppressWarnings("all")
public class PreTree {
    public Node head = new Node();

    public static class Node{
        public int starts;
        public int ends;
        public Node[] roads = new Node[26];//只以26个小写字母组成的字符串为例
    }

    public void initTree(char[] arr){
        if(arr == null || arr.length == 0) return ;
        Node cur = head;
        int index;
        for (char c : arr) {
            index = c - 'a';//计算当前char对应在路中的位置,因为'a'的ascii码为0，因此所有其他的char都能根据a找到其在数组中对应的位置
            if (cur.roads[index] == null){
                cur.roads[index] = new Node();
            }
            cur.roads[index].starts++;//改变对应这一条路的节点的信息
            cur = cur.roads[index];
        }
        cur.ends++;
    }

    /**
     * 删除对应的字符串
     * @param arr 字符串的字符数组
     */
    public void delete(char[] arr){
        if (arr == null || arr.length == 0)return;
        if (search(arr) == 0) return;
        Node cur = head;
        int index;
        for (char c : arr){
            index = c - 'a';
            cur.roads[index].starts--;
            if (cur.roads[index].starts == 0){//这条路上已经没有值了
                cur.roads[index] = null;
                return;
            }
            cur = cur.roads[index];

        }
        cur.ends--;
    }

    /**
     * 查找这个字符串在前缀树中存在几条
     * @param arr 字符串对应的数组
     * @return 条数
     */
    public int search(char[] arr){
        if (arr == null || arr.length == 0)return 0;
        Node cur = head;
        int index;
        for (char c : arr) {
            index = c - 'a';
            if (cur.roads[index] == null){
                return 0;
            }
            cur = cur.roads[index];
        }
        return cur.ends;
    }

    /**
     * 以这个字符串开头的字符串个数
     * @param arr 字符串对应的数组
     * @return 个数
     */
    public int prefixNum(char[] arr){
        if (arr == null || arr.length == 0) return 0;
        Node cur = head;
        int index;
        for (char c : arr) {
            index = c - 'a';
            if (cur.roads[index] == null){
                return 0;
            }
            cur = cur.roads[index];
        }
        return cur.starts;
    }
}
