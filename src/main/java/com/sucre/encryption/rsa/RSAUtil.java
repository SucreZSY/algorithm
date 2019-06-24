package com.sucre.encryption.rsa;




import org.apache.commons.lang3.ArrayUtils;

import javax.crypto.Cipher;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    private static Cipher cipher;
    private static String KeyPairGeneratorType = "RSA";
    //private static String RSA_TYPE_CIPHER = "RSA";
    //private static String RSA_TYPE_CIPHER = "RSA/ECB/NoPadding";
    private static String RSA_TYPE_CIPHER = "RSA/ECB/PKCS1Padding";

    public static void initCipher() {
        try {
            //得到Cipher对象来实现对源数据的RSA加密
            cipher = Cipher.getInstance(RSA_TYPE_CIPHER);
            //cipher = Cipher.getInstance(RSA_TYPE_CIPHER, new BouncyCastleProvider());
        } catch (Exception e) {
            cipher = null;
            e.printStackTrace();
        }
    }

    /**
     * 生成密钥对,第一个是私钥，第二个是公钥
     */
    public static Key[] getKeyPair() throws Exception {
        //为RSA算法创建一个KeyPairGenerator对象,安卓用的是另一个获取,与java不同
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KeyPairGeneratorType);
        //第一个参数是密钥长度,第二个参数是随机生成
        keyPairGenerator.initialize(1024, new SecureRandom());
        //生成密匙对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        Key privateKey = keyPair.getPrivate();
        Key publicKey = keyPair.getPublic();
        Key[] keys = new Key[]{privateKey, publicKey};
        return keys;
    }

    public static String[] getKeyPairInString() throws Exception {
        //数组内 0私钥 1公钥
        Key[] keys = getKeyPair();
        String privateKey = Bae64Util.encodeByBase64(keys[0].getEncoded());
        String publicKey = Bae64Util.encodeByBase64(keys[1].getEncoded());
        String[] result = {privateKey, publicKey};
        return result;
    }

    /**
     * 从string中获取privateKey
     */
    public static PrivateKey getPrivateKeyInString(String source) throws IOException {
        byte[] privateKeyBytes = Bae64Util.decodeByBase64(source);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        try {
            KeyFactory factory = KeyFactory.getInstance(KeyPairGeneratorType);
            PrivateKey privateKey = factory.generatePrivate(pkcs8EncodedKeySpec);
            return privateKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从string中获取公钥,公钥是getEncode方法后用base64加压成的string
     */
    public static PublicKey getPublicKeyFromString(String source) throws Exception {
        byte[] publicKeyBytes = Bae64Util.decodeByBase64(source);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory factory = KeyFactory.getInstance(KeyPairGeneratorType);
        PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);
        return publicKey;
    }

    /**
     * 加密,使用base64压缩返回
     */
    public static String encryptByKey(String source, Key publicKey) throws Exception {
        if (cipher == null) {
            initCipher();
        }
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        // 执行加密操作
        byte[] sourceBytes = source.getBytes();
        if (sourceBytes.length > 127) {
            //加密时超过117字节就报错。为此采用分段加密的办法来加密
            byte[] enBytes = null;
            for (int i = 0; i < sourceBytes.length; i += 64) {
                //注意要使用2的倍数，否则会出现加密后的内容再解密时为乱码
                byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(sourceBytes, i, i + 64));
                enBytes = ArrayUtils.addAll(enBytes, doFinal);
                return Bae64Util.encodeByBase64(enBytes);
            }
        }
        byte[] resultBytes = cipher.doFinal(sourceBytes);
        return Bae64Util.encodeByBase64(resultBytes);
    }

    /**
     * 解密
     * Author: John Tang
     * Date: 2017/2/22 - 16:17
     */
    public static String decryptByKey(String source, Key privateKey) throws Exception {
        if (cipher == null) {
            initCipher();
        }
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] sourceBytes = Bae64Util.decodeByBase64(source);
        if (sourceBytes.length >= 128) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sourceBytes.length; i += 128) {
                byte[] doFinal = cipher.doFinal(ArrayUtils.subarray(sourceBytes, i, i + 128));
                sb.append(new String(doFinal));
            }
            return sb.toString();
        }
        // 执行解密操作
        byte[] resultBytes = cipher.doFinal(sourceBytes);
        return new String(resultBytes);
    }
    /*需要的话,在pom里打开pkck8转换*/
    /*public String PKCS8ToPKCS1(Key privateKey) throws IOException {
        byte[] encoded = privateKey.getEncoded();
        PrivateKeyInfo pki = PrivateKeyInfo.getInstance(encoded);
        RSAPrivateKeyStructure pkcs1Key = RSAPrivateKeyStructure.getInstance(pki.getPrivateKey());
        byte[] pkcs1Bytes = pkcs1Key.getEncoded();
        return Bae64Util.encodeByBase64(pkcs1Bytes);
    }*/

    public static void main(String[] args) {

    }
}
