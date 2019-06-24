package com.sucre.leetcode.stack;

import java.util.Stack;

/**
 * 使用栈计算操作数的数组
 */
public class EvalRPN {
    /**
     * 计算操作符数组的结果
     * @param tokens 操作数的数组 比如 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3)遇到运算符就把前两个弹出并计算    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     * @return
     */
    public int evalRPN(String[] tokens){
        Stack<String> help = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])){
                int b = Integer.parseInt(help.pop());
                int a = Integer.parseInt(help.pop());
                help.push(cal(tokens[i], a, b));
            }else {
                help.push(tokens[i]);
            }
        }
        return Integer.parseInt(help.pop());
    }

    /**
     * 根据运算符计算结果的方法
     * @param sign 运算符
     * @param a 数a
     * @param b 数b
     * @return a,b运算结果
     */
    public String cal(String sign, int a, int b){
        switch (sign){
            case "+" :{
                return a + b + "";
            }
            case "-" :{
                return a - b + "";
            }
            case "*" :{
                return a * b + "";
            }
            case "/" :{
                return a / b + "";
            }
        }
        return "";
    }


}
