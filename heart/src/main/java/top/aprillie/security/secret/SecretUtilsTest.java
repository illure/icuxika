package top.aprillie.security.secret;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/8/30 17:17
 * @Modified By:
 */
public class SecretUtilsTest {

    public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, IOException, InvalidKeySpecException {
        System.out.println("后端AES加密数据：" + AESUtils.encrypt("后端AES加密数据"));
        System.out.println("后端RSA私钥加密数据：" + RSAUtils.encryptByPrivateKey("后端RSA私钥加密数据"));
        System.out.println("后端RSA公钥加密数据：" + RSAUtils.encryptByPublicKey("后端RSA公钥加密数据"));

        System.out.println("后端AES解密前端AES加密数据：" + AESUtils.decrypt("FCAw57wRDasdZ32UZxLu24zQE0p8o9ICpt08bzT6oEY="));
        System.out.println("后端RSA私钥解密前端公钥加密数据：" + RSAUtils.decryptByPrivateKey("ZXDgQnAkoI4TM6RZJQmBvjmX9oBhW4a5oLmsjLre49A3uwjBu9O1fP4QxaS3Os1mWQQrs6IHC2aonSw5xMPfW1/gd3TKwdyLm2m0wtFAiC71d16a1s5JaNWIChBz3dwcz6uCw4mgxlSdIr+ccur1DSjsEvxm0QdcVo4W2pDQUuk="));
        System.out.println("后端RSA公钥解密前端私钥加密数据：" + RSAUtils.decryptByPublicKey("tLorXYJUzh4eVSkvZONQuGoez6ffGNNboYB7p+lB5nZPiCL4s5sExvGe966rsYAKUliQQfrHjFc6BFSMBk0zX9cLX81elLXp0aIHD3RziQeDVx6ubyNlYUiKRqWznKQcHrV36g8zDEdvAl9u/IWlBSVLZVcqIlKdv3ykyEMo3rM="));

    }
}
