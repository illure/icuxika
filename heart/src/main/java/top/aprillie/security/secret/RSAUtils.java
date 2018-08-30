package top.aprillie.security.secret;

import org.apache.commons.codec.binary.Base64;
import top.aprillie.common.constants.Constants;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @Author: illure
 * @Description: 对称加密 RSA 算法工具类
 * @Date: Created in 2018/8/30 17:14
 * @Modified By:
 */
public class RSAUtils {

    /**
     * RSA通过私钥加密
     *
     * @param data 待加密数据
     * @return String 密文
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws IOException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    public static String encryptByPrivateKey(String data) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return Base64.encodeBase64String(RSACoder.encryptByPrivateKey(data.getBytes(StandardCharsets.UTF_8), Base64.decodeBase64(Constants.RSA_PRIVATE_KEY)));
    }

    /**
     * RSA通过公钥加密
     *
     * @param data 待加密数据
     * @return String 密文
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    public static String encryptByPublicKey(String data) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return Base64.encodeBase64String(RSACoder.encryptByPublicKey(data.getBytes(StandardCharsets.UTF_8), Base64.decodeBase64(Constants.RSA_PUBLIC_KEY)));
    }

    /**
     * RSA通过私钥解密
     *
     * @param cipherText 待解密数据
     * @return String 原文
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws IOException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    public static String decryptByPrivateKey(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return new String(RSACoder.decryptByPrivateKey(Base64.decodeBase64(cipherText), Base64.decodeBase64(Constants.RSA_PRIVATE_KEY)));
    }

    /**
     * RSA通过公钥解密
     *
     * @param cipherText 待解密数据
     * @return String 原文
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     */
    public static String decryptByPublicKey(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return new String(RSACoder.decryptByPublicKey(Base64.decodeBase64(cipherText), Base64.decodeBase64(Constants.RSA_PUBLIC_KEY)));
    }
}
