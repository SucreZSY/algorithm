package com.sucre.swordoffer;

/**
 * 找到数组中只出现一次的数字
 * 要求：
 *   num1,num2分别为长度为1的数组。传出参数
 *   将num1[0],num2[0]设置为返回结果
 */
public class FindOneInArray {
    /**
     * 数组中其他元素都出现了两次，只有一个数出现了一次，找出这个数
     * @param array 目标数组
     * @param num1 长度为1的数组，用于记录返回结果
     * @param num2 同num1
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) return ;
        //思路非常简单
        //一路异或下去，最后就是只有一次的那个（两个相同的数异或结果是0，0和其他数异或能保持原数）
        int res = 0;
        for (int i = 0; i < array.length; i++){
            res ^= array[i];
        }
        num1[0] = res;
        num2[0] = res;
    }

    /**
     * 数组中其他元素都出现了两次，只有两个数出现了一次，找出这两个数
     * @param array 目标数组
     * @param num1 长度为1的数组，用于记录返回结果
     * @param num2 同num1
     */
    public void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) return ;
        //思路非常简单
        //一路异或下去，最后的结果就是那两个数异或的结果，肯定有某几位上的数为1，找到第一个为1的位，按照这一位上是否为1将数组分为两份（两个相同的数异或结果是0，0和其他数异或能保持原数）
        int res = 0;
        int indexBit = 0;
        for (; indexBit < array.length; indexBit++){
            res = res ^ array[indexBit];
        }
        //找到res上第一位为1的数
        indexBit = 0;
        while (indexBit <= 32 && (res & 1) != 1){
            res >>= 1;
            indexBit++;
        }

        //按这一位上是不是1分类
        for (int i = 0; i < array.length; i++){
            if (((array[i] >> indexBit) & 1) == 1){//先右移对应位，使要判断的位处于最后一位，与1进行与操作，相当于求模
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }
    /**
     * 数组中的数字随机从1 - n中选取了n - 1个数，两两互不相等，求未出现的数
     * @param array 目标数组
     * @param num1 长度为1的数组，用于记录返回结果
     * @param num2 同num1
     */
    public void FindNumsDisAppear(int [] array,int num1[] , int num2[]){
        if (array == null || array.length == 0) return ;
        //思路：
            //更简单，我先把这里的数全异或一遍，然后从1开始，异或到n，这样这n - 1个数都变成了0，剩下的就是未出现的数了
            //类似于补虚轴的做法，找最大回文子串时处理偶数长度字符串的情况
        int n = array.length + 1;
        int res = 0;
        for (int i : array) {
            res ^= i;
        }
        while (n != 0){
            res ^= n--;
        }
        num1[0] = res;
        num2[0] = res;
    }

    public static void main(String[] args) {
       int a = 10;
       int b = 20;

       int mid = a + ((b - a) >> 1);

       System.out.println(mid);
    }


}
