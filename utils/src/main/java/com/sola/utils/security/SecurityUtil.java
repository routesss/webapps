package com.sola.utils.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


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
     * Base64就是一种基于64个可打印字符来表示二进制数据的方法,详情百度
     */

    /**
     * byte 转 bate64
     * @param buffer
     * @return
     */
    public static String toBate64(byte[] buffer){

        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(buffer);

        //byte[] encode1 = Base64.getEncoder().encode(buffer);

        return encode ;
    }

    /**
     * bate64 转 byte
     * @param buffer
     * @return
     * @throws Exception
     */
    public static byte[] toByte(String buffer) throws Exception{
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(buffer);

        //byte[] decode = Base64.getDecoder().decode(buffer);

        return bytes ;
    }

    /**
     * 通过KeyPairGenerator获取密钥对 加解密测试
     * @throws Exception
     */
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

    //-------------------------------------------分割线 bate64数据形式保存的公钥私钥加解密测试---------------------------------------------

    /**
     * 将base64编码后的公钥字符串转成PublicKey实例
     * @param publicKey  公钥的byte64数据
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception{
        byte[] decode = toByte(publicKey) ;

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePublic(keySpec) ;
    }

    /**
     * 将base64编码后的私钥字符串转成PrivateKey实例
     * @param privateKey 私钥的byte64数据
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception{
        byte[] bytes = toByte(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        return keyFactory.generatePrivate(keySpec) ;
    }

    /**
     * 使用bate64数据保存的公钥和私钥 加解密测试
     * @throws Exception
     */
    public static void testTwo()  throws Exception{
        //公钥bate64数据
        String publicKeyBate64 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCatleNvkKG/kAD22/JY4ODnBNym9oD31yVuimEYHR8/tRgxCnNpjFs8GuVlYzq1RXsF0PhJtlPXD6FR4S+5++ZGnR6b0J4sw2xcx3JhMRaSipnrXeOEpKmNRI0CWOqSF9t3bjxZ5B725Hl5bZLO1fFgSO7vVTGCYwDidTwZ/bTpQIDAQAB" ;

        //私钥bate64数据
        String privateKeyBate64 = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAJq2V42+Qob+QAPbb8ljg4OcE3Kb2gPfXJW6KYRgdHz+1GDEKc2mMWzwa5WVjOrVFewXQ+Em2U9cPoVHhL7n75kadHpvQnizDbFzHcmExFpKKmetd44SkqY1EjQJY6pIX23duPFnkHvbkeXltks7V8WBI7u9VMYJjAOJ1PBn9tOlAgMBAAECgYEAhgXx4MtyDElSoUTGGRrJAgkB2+XhPjuPk/FaJ9/66ZFD37PvVsRiyrGXMVUFZyVCwWwCFJi35gTN8F1dRJfduVNORIPY9GZLn5lu9vkHoyVbiDquLpSlOij9/2S4Dg5SXNYycQG0NdNN9YVer3xOBxmpRIJCtrOP9ZqSPcqITQECQQDiJjRbliJ7soBFVkcKF1e9z+dGH9OB6nTs/hQqvCxYepdz5RxYwkFIrzFXZkVTBb0xMNLUpNl9xPAA9yDIKTRBAkEAryI3HWbim82AHKMrF1lng3Hf4n2/wYPQMqMANR/5UNNzDQuS6pv/pBIwFD0uCg9z2CEOWKiGTImwAECZ5M+2ZQJBAIJjeKidpYAgaOiRWCAvWT1tU3ERBIfRQF0sGUCSghb5h70gifl69t0Lda1on+vAUVa9SbGk4mkrVR2ZXuNJLoECQDVWvmJ+C1ZYaERQjbc2y4gFDqL0mYpekvJZIp8Ldetf+xJmDADYMivOPkZru7HksuuIZc4qxXxaEviAtF4zxOECQQDcr7NPSUG7n8A5/KOilann0ZA8EQNkOu1AskGaWdGXOxEhhzvycECpY3uGx1DUAonGENdBGMtb2dUKft3QSNCl" ;

        //内容
        String content = "hello sola" ;

        PublicKey publicKey = getPublicKey(publicKeyBate64); //公钥

        PrivateKey privateKey = getPrivateKey(privateKeyBate64); //私钥

        byte[] buffer = encrpt(content.getBytes(), publicKey);//公钥加密
        System.out.println("---------------------------");
        System.out.println(new String(buffer));//加密内容
        System.out.println("---------------------------");
        buffer = decrypt(buffer, privateKey) ;//私钥解密
        System.out.println(new String(buffer));//解密内容
    }

    //----------------------------------------------------------------------------------------------------------------------

}
