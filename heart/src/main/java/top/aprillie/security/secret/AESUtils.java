package top.aprillie.security.secret;

import org.apache.commons.codec.binary.Base64;
import top.aprillie.common.constants.Constants;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: illure
 * @Description: 对称加密 AES 算法工具类
 * @Date: Created in 2018/8/30 17:13
 * @Modified By:
 */
public class AESUtils {

    /**
     * AES加密
     *
     * @param data 待加密数据
     * @return String 密文
     * @throws NoSuchPaddingException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    public static String encrypt(String data) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return Base64.encodeBase64String(AESCoder.encrypt(data.getBytes(StandardCharsets.UTF_8), Constants.AES_SECRET_KEY.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * AES解密
     *
     * @param cipherText 待解密数据
     * @return String 原文
     * @throws NoSuchPaddingException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     */
    public static String decrypt(String cipherText) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return new String(AESCoder.decrypt(Base64.decodeBase64(cipherText), Constants.AES_SECRET_KEY.getBytes(StandardCharsets.UTF_8)));
    }
}
