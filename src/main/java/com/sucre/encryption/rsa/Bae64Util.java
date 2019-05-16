package com.sucre.encryption.rsa;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Bae64Util {

    private static BASE64Encoder base64Encoder = new BASE64Encoder();
    private static BASE64Decoder base64Decoder = new BASE64Decoder();

    /**
     * 使用base64加密
     */
    public static String encodeByBase64(byte[] bytes) {
        return base64Encoder.encode(bytes);
    }

    /**
     * 使用base64解密
     */
    public static byte[] decodeByBase64(String source) throws IOException {
        return base64Decoder.decodeBuffer(source);
    }
}
