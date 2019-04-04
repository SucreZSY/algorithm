package com.sucre.swordoffer;

import java.util.Arrays;

/**
 * 顺子带一对
 */
public class Card {
    /**
     * 判断一个数组是否是顺子带2
     * @param arr
     * @return
     */
    public static boolean isThreeAndTwo(int[] arr){
        Arrays.sort(arr);
        if (arr[0] == arr[1]){//说明后面三个只能连续
            return (arr[2] == arr[3] - 1 && arr[3] == arr[4] - 1);
        }
        if (arr[0] + 1 == arr[1]){//说明从现在开始，要么23连续45相同，要么234相同45连续
            if (arr[2] - arr[1] == 1){
                //23也连续
                return arr[3] == arr[4];
            }else {
                //234必须相同且45连续
                return (arr[1] == arr[2] && arr[2] == arr[3] && arr[3] == arr[4] - 1 );
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,2,4,5};
        int[] arr3 = {1,2,3,4,4};
        int[] arr4 = {1,2,3,2,2};
        int[] arr5 = {5,6,7,9,9};
        int[] arr6 = {2,3,4,5,5};
        int[] arr7 = {1,2,2,2,3};
        int[] arr8 = {1,1,7,8,9};
        int[] arr9 = {1,1,1,1,1};
        int[] arr10 = {1,2,3,3,3};

        System.out.println("arr1:" + isThreeAndTwo(arr1));
        System.out.println("arr2:" + isThreeAndTwo(arr2));
        System.out.println("arr3:" + isThreeAndTwo(arr3));
        System.out.println("arr4:" + isThreeAndTwo(arr4));
        System.out.println("arr5:" + isThreeAndTwo(arr5));
        System.out.println("arr6:" + isThreeAndTwo(arr6));
        System.out.println("arr7:" + isThreeAndTwo(arr7));
        System.out.println("arr8:" + isThreeAndTwo(arr8));
        System.out.println("arr9:" + isThreeAndTwo(arr9));
        System.out.println("arr10:" + isThreeAndTwo(arr10));

    }
}
