package com.sucre.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucre
 * @desc leetcode 第6题 https://leetcode.cn/problems/zigzag-conversion/
 * @date 2023/1/11
 */
public class Code_006 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *  
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 由英文字母（小写和大写）、',' 和 '.' 组成
     * 1 <= numRows <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        //题解: https://leetcode.cn/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/

        /**
         * 分析： 题目很简单
         *     将字符按对应顺序填到指定行的字符末尾，假设行数为4， 则下标为0,1,2,3
         *     那么只用依次将字符填充到  0 - 1 - 2 - 3 - 2 - 1 - 0 - 1 - 2 - 3 行的末尾
         *
         *     按照规律即按位遍历字符串, 递增/递减归类(每到0, 3反转)即可
         */
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        List<StringBuilder> rowStringList = new ArrayList<>();
        int i = 0;
        while (i < numRows) {
            rowStringList.add(new StringBuilder());
            i++;
        }
        i = 0;
        int flag = -1;//因为初次是正向遍历 第一个元素就要反转 因此初始化为-1
        for (char c : s.toCharArray()) {
            rowStringList.get(i).append(c);
            // 到达端点时需要反转
            if (i == 0 || (i == numRows -1)) {
                flag = -flag;
            }
            i += flag;//将下一个字符放到正确的行数上
        }
        StringBuilder finalString = new StringBuilder();
        for (StringBuilder row : rowStringList) {
            finalString.append(row.toString());
        }

        return finalString.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }


}
