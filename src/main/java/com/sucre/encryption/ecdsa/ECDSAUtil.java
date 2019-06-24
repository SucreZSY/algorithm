package com.sucre.encryption.ecdsa;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * ECDSA签名算法
 */
public class ECDSAUtil {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
    keyPairGenerator.initialize(256);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        byte[] privateKey = keyPair.getPrivate().getEncoded();
        byte[] publicKey = keyPair.getPublic().getEncoded();

        String content = "helloworld";

        byte[] sign = sign(content.getBytes(), privateKey);
        System.out.println("dsa sign:"+ Base64.getEncoder().encodeToString(sign));

        Boolean flag = verify(content.getBytes(), sign, publicKey);
        System.out.println("dsa verify:"+flag);
    }

    public static byte[] sign(byte[] content, byte[] privateKey) throws Exception {
        //单例获取key工厂类，将拿到的privateKey创建PKCS8EncodedKeySpec对象，通过其获取PrivateKey对象
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PrivateKey priKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKey));

//获取Signature对象，签名算法为SHA1withDSA，此处还有较多可选择比如MD5withDSA等
        Signature signature = Signature.getInstance("SHA1withECDSA");
        signature.initSign(priKey);
        signature.update(content);
        byte[] encodeResult = signature.sign();
        return encodeResult;
    }

    public static boolean verify(byte[] content, byte[] sign, byte[] publicKey) throws Exception{
        //单例获取key工厂类，将拿到的publicKey创建X509EncodedKeySpec对象，通过其获取PublicKey对象
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));

//获取Signature对象，签名算法为SHA1withDSA，此处还有较多可选择比如MD5withDSA等
        Signature signature = Signature.getInstance("SHA1withECDSA");
        signature.initVerify(pubKey);
        signature.update( content );
        boolean bverify = signature.verify(sign);
        return bverify;
    }
}
