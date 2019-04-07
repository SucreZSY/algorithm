package com.sucre.algorithm.hash;

import java.util.*;

/**
 * 实现能等概率获取随机key的方法，删除一个key时移动操作比较重要
 */
public class RandomPool {
    public HashMap<Object, Integer> keys;
    public HashMap<Integer, Object> seq;
    private int size;//从1开始

    public RandomPool() {
        this.keys = new HashMap<>();
        this.seq = new HashMap<>();
        this.size = 0;
    }

    /**
     * 增加的操作
     * @param key 要增加的key
     */
    public void insert(Object key){
        if (!keys.containsKey(key)){//不重复添加
            this.keys.put(key, this.size);
            this.seq.put(this.size++, key);
        }
    }

    /**
     * 获取随机key的方法
     * @return 得到的key
     */
    public Object getRandom(){
        //主要思路
            //首先随机的获取到一个index，然后找到这个index对应的key即可
        int seq = (int) (Math.random() * this.size);
        return this.seq.get(seq);
    }

    /**
     * 这个方法比较复杂，因为我们要根据size来获取随机数，如果删除了一个key的话就会造成size不连续，就不会均匀等概率
     * @param key 删除的key
     */
    public void remove(Object key){
        //主要思路
            //先记录好删除的index，用最大size对应的key来填补这个缺口，然后把size-1即可
        if (keys.containsKey(key)){
            int index = keys.get(key);
            this.size--;//每次size所在的位置是null，他的上一位才是有值的
            keys.put(seq.get(this.size), index);//使用最后一个key替换，不能先删除，先删除就无法找到最后一个key了
            seq.put(index, seq.get(this.size));
            keys.remove(key);
            seq.remove(this.size);//seq删除的应该是最后一位，因为相当于是把删除的key移动到了最后一位上
        }
    }

    public boolean contains(Object key){
        if (keys.containsKey(key)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        RandomPool pool = new RandomPool();
        List<String> lessons = new ArrayList<>();
        lessons.add("a");
        lessons.add("b");
        lessons.add("c");
        lessons.add("d");
        lessons.add("e");
        lessons.add("f");
        lessons.add("g");
        lessons.add("h");
        lessons.add("i");
        lessons.add("j");
        lessons.add("k");
        lessons.add("l");
        lessons.add("m");
        lessons.add("n");

        for (String lesson : lessons) {
            pool.insert(lesson);
        }

        String[][] persons = {{"a","c"},{"d","c"},{"j","k"},{"a","b"},{"e",null},{"e",null}};

        for (int i = 0; i < persons.length; i++){
            for (int j = 0; j < persons[0].length; j++){
                if (pool.contains(persons[i][j])){
                    pool.remove(persons[i][j]);
                }else {
                    persons[i][j] = null;
                }
            }
        }
        for (int i = 0; i < persons.length; i++){
            System.out.print("第" + i + "个人：");
            for (int j = 0; j < persons[0].length; j++){
                if (persons[i][j] != null){
                    System.out.print(persons[i][j] + " ");
                }else {
                    Object key = pool.getRandom();
                    System.out.print(key + " ");
                    pool.remove(key);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("还剩:");
        Set<Object> keySet = pool.keys.keySet();
        for (Object o : keySet) {
            System.out.print(o + "    ");
        }
    }
}
