package com.sucre.demo;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 返回一个相对安全的token
 */
public class TokenEncryption {
    /**
     * 将用户id与当前ip表示的数进行异或然后转化为十六进制的方法
     * @param userId 用户id
     * @param requestIP 用户请求的ip
     * @return 返回结果的十六进制表示
     */
    public static String encryptionToken(Long userId, Long requestIP){
        if (userId == null || requestIP == null) throw new RuntimeException("Bad Request");
        return Long.toHexString(userId ^ requestIP);
    }

    /**
     * 根据ip地址校验token是否合法的方法
     * @param userId 待检验id
     * @param token 提交的token
     * @param requestIp 目前请求的ip
     * @return 是否合法
     */
    public static boolean decipherToken(Long userId, String token, Long requestIp){
        if (userId == null || token == null || requestIp == null) return false;
        return userId.equals(Long.parseLong(token, 16) ^ requestIp);
    }
    public static void main(String[] args) {
        String s = TokenEncryption.encryptionToken(1000L, 19216825133L);
        System.out.println(s);
        System.out.println(Long.parseLong(s, 16));
        System.out.println(19216824517L ^ 19216825133L);
        System.out.println(TokenEncryption.decipherToken(1000L, s, 19216825133L));

    }

}
