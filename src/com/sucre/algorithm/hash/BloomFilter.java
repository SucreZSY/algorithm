package com.sucre.algorithm.hash;

/**
 * 布隆过滤器的简单实现
 */
public class BloomFilter {
    public static void main(String[] args) {
        int[] arr = new int[1000];//有大小为1000的数组，可以映射的bit为32000
        int hash = 30000;//假设一条url的hashcode为30000
        int indexArray = hash / 32;//找到其在数组中的位置，一个数组元素占用32的大小
        int indexBit = hash % 32; // 找到其对应在元素的哪一位上面
        //找到对应的位置后，将对应的bit变为1，说明此处已经存在url
        arr[indexArray] = arr[indexArray] | (1 << indexBit);//或的操作是有1就是1，否则是0，与原来的数据进行或操作能保留下所有的1
        //如果indexBit 为 16，说明第16位上应该是1，把1用二进制表示后左移16位即可表示

        System.out.println(indexArray + "和" + indexBit);
    }
}
