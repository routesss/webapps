package com.sola.utils.security;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SecurityUtil {


    /**
     * 记录 {签名(bate64 + 私钥加密) -- 公钥解密  -- 公钥一方用公钥解密数字签名部分，将明文数据做bate64对比数据指纹,确认发送者和数据完整性}
     */

    /**
     * 私钥解密
     * @param content 内容
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception{
        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.DECRYPT_MODE, privateKey);
        return rsa.doFinal(content) ;
    }

    /**
     * 公钥加密
     * @param content 内容
     * @param publicKey 公钥
     * @return
     * @throws Exception
     */
    public static byte[] encrpt(byte[] content, PublicKey publicKey) throws Exception{

        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.ENCRYPT_MODE, publicKey);

        return rsa.doFinal(content) ;
    }

    /**
     * 生成密钥对
     * @param keyLength 密钥长度
     * @return
     * @throws Exception
     */
    public static KeyPair getKeyPair(int keyLength) throws Exception{

        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        rsa.initialize(1024);

        return rsa.generateKeyPair() ;
    }

    /**
     * byte 转 bate64
     * Base64就是一种基于64个可打印字符来表示二进制数据的方法
     * @param buffer
     * @return
     */
    public static String toBate64(byte[] buffer){

        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(buffer);

        return encode ;
    }

    public static void testOne() throws Exception{

        String content = "hello world!" ;

        KeyPair keyPair = getKeyPair(1024);

        PublicKey publicKey = keyPair.getPublic();//公钥
        System.out.println("publicKey bate64 : " + toBate64(publicKey.getEncoded()));
        System.out.println("--------------------------");

        PrivateKey privateKey = keyPair.getPrivate();//私钥
        System.out.println("privateKey bate64 : " + toBate64(privateKey.getEncoded()));
        System.out.println("--------------------------");

        byte[] buffer = encrpt(content.getBytes(), publicKey);//公钥加密

        System.out.println("原文 : " + content);
        System.out.println("--------------");
        System.out.print("加密后 : ");
        System.out.println(new String(buffer));
        System.out.println("-------------------");

        buffer = decrypt(buffer, privateKey); //私钥解密
        System.out.println("解密后 : " + new String(buffer));

    }



}
