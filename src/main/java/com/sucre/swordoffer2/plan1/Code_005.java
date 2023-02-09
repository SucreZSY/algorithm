package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/ti-huan-kong-ge-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/9
 */
public class Code_005 {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ti-huan-kong-ge-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        String space = " ";
        String replaceStr = "%20";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (space.equals(String.valueOf(aChar))) {
                sb.append(replaceStr);
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
