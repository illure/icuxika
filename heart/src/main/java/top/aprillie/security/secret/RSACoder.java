package top.aprillie.security.secret;

import org.bouncycastle.asn1.*;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/8/30 17:14
 * @Modified By:
 */
public class RSACoder {

    /**
     * 密钥算法
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * RSA通过私钥加密
     *
     * @param data 待加密数据
     * @param key  RSA私钥
     * @return byte[] 二进制密文
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    static byte[] encryptByPrivateKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = makePrivateKey(key);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * RSA通过公钥加密
     *
     * @param data 待加密数据
     * @param key  RSA公钥
     * @return byte[] 二进制密文
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    static byte[] encryptByPublicKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * RSA通过私钥解密
     *
     * @param data 待解密数据
     * @param key  RSA私钥
     * @return byte[] 二进制原文
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    static byte[] decryptByPrivateKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = makePrivateKey(key);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * RSA通过公钥解密
     *
     * @param data 待解密数据
     * @param key  RSA公钥
     * @return byte[] 二进制原文
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    static byte[] decryptByPublicKey(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * 将私钥转换成PKCS8格式
     *
     * @param privateKeyData 私钥
     * @return PrivateKey PKCS8格式的私钥
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private static PrivateKey makePrivateKey(byte[] privateKeyData) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        ASN1EncodableVector vector1 = new ASN1EncodableVector();
        vector1.add(new ASN1Integer(0));
        ASN1EncodableVector vector2 = new ASN1EncodableVector();
        vector2.add(new ASN1ObjectIdentifier(PKCSObjectIdentifiers.rsaEncryption.getId()));
        vector2.add(DERNull.INSTANCE);
        vector1.add(new DERSequence(vector2));
        vector1.add(new DEROctetString(privateKeyData));

        ASN1Sequence sequence = new DERSequence(vector1);
        byte[] privateKeyByte = sequence.getEncoded("DER");
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKeyByte);
        KeyFactory factory = KeyFactory.getInstance("RSA");

        return factory.generatePrivate(spec);
    }
}
