import CryptoJS from 'crypto-js'
import NodeRSA from 'node-rsa'

/**
 * 对称加密 AES 算法工具
 */
const AESSecretKey = '12345678abcdefgh'

/**
 * AES加密
 */
/**
 * @return {string}
 */
function AESEncrypt (data) {
  data = CryptoJS.enc.Utf8.parse(data)
  let secretKey = CryptoJS.enc.Utf8.parse(AESSecretKey)
  let cipherData = CryptoJS.AES.encrypt(data, secretKey, {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7
  })
  return cipherData.ciphertext.toString(CryptoJS.enc.Base64)
}

/**
 * AES解密
 */
/**
 * @return {string}
 */
function AESDecrypt (cipherText) {
  let secretKey = CryptoJS.enc.Utf8.parse(AESSecretKey)
  let decryptedData = CryptoJS.AES.decrypt(cipherText, secretKey, {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7
  })
  return decryptedData.toString(CryptoJS.enc.Utf8)
}

/**
 * 非对称加密 RSA 算法工具
 */
const RSAPrivateKeyPem =
  '-----BEGIN RSA PRIVATE KEY-----\n' +
  'MIICXQIBAAKBgQDDGNtRfvIidWIspD1Z9SmAY+QGURJOjnT7Lx75FosL+xllIAS9\n' +
  'rV8ETyVq0X1RoZN/VMfnDwapwfQSbtbHEIOOQ8YyQKPIivDn9bMOFE5drWkwSNpI\n' +
  'teb25F5ASoM04Wz8aJUsN2UtkXSvhfh4eUzeN7TF+xWSudu0OuPsgXlbXQIDAQAB\n' +
  'AoGBALET8py5uFSGbqFOQVFRMGYURHdnRlJ/AraqQlabm4E4XAhpU2RF5CQpIjEe\n' +
  'C7z4BsRf00FpZgbWwA2rBM6RspTp+odg4sk4oUmCDl0oVKxHjod9JOEPPyN0HUZE\n' +
  'eGrN8uFlJiFpiZJfn7RCzmucAtLmrz9y4q7dn3RE8Mve3YkBAkEA+I3L3YIlqLg0\n' +
  'D4tnOMbXqeOMby2RhkOfM4IsBrtPLDguEH9VsIOiQIWx2OUBCgOHtNdwQ0dzP+8P\n' +
  'JBWQXd4HTQJBAMjxFzyLPU1a5i+guet6w8d3C8tMfjjY2fmbHifdPyUyrJpl/vLN\n' +
  '7+EddDSumFsigZfXDztVZ+WyG1Fq6DMPPFECQCeExAkwDDTLNNvT2lGYq+mDGG0E\n' +
  '3cJvNfzGkaFwXqI1PH27ATDTfRStLR3DK2sgLI+AQYUw8w4TQGEIXK/QAXECQAcn\n' +
  '/unbE53TpOsBUF3Ai4RpCvR8juo7Xtfy3EoTKRKMEXWWOFQxXV+pCuBtb2OfgPoF\n' +
  'YLd+PSsDAtINeqOG4WECQQC6WPYfOPL3LiAdgu8zslCpD65IPF8cYQb3P/Fmm7Rh\n' +
  'q3PfQyEcq1lj7uLdNY/wDJ0UN+rZ/jSBcdEX/EsihfOL\n' +
  '-----END RSA PRIVATE KEY-----'

const RSAPublicKeyPem =
  '-----BEGIN PUBLIC KEY-----\n' +
  'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDGNtRfvIidWIspD1Z9SmAY+QG\n' +
  'URJOjnT7Lx75FosL+xllIAS9rV8ETyVq0X1RoZN/VMfnDwapwfQSbtbHEIOOQ8Yy\n' +
  'QKPIivDn9bMOFE5drWkwSNpIteb25F5ASoM04Wz8aJUsN2UtkXSvhfh4eUzeN7TF\n' +
  '+xWSudu0OuPsgXlbXQIDAQAB\n' +
  '-----END PUBLIC KEY-----'

const RSAPrivateKey = new NodeRSA(RSAPrivateKeyPem)
const RSAPublicKey = new NodeRSA(RSAPublicKeyPem)
RSAPrivateKey.setOptions({ encryptionScheme: 'pkcs1' })
RSAPublicKey.setOptions({ encryptionScheme: 'pkcs1' })

/**
 * RSA公钥加密
 */
function RSAEncryptByPublicKey (data) {
  return RSAPublicKey.encrypt(data, 'base64', 'utf8')
}

/**
 * RSA私钥解密
 */
function RSADecryptByPrivateKey (cipherText) {
  return RSAPrivateKey.decrypt(cipherText, 'utf8')
}

/**
 * RSA私钥加密
 */
function RSAEncryptByPrivateKey (data) {
  return RSAPrivateKey.encryptPrivate(data, 'base64', 'utf8')
}

/**
 * RSA公钥解密
 */
function RSADecryptByPublicKey (cipherText) {
  return RSAPublicKey.decryptPublic(cipherText, 'utf8')
}

export default {
  AESEncrypt,
  AESDecrypt,
  RSAEncryptByPublicKey,
  RSADecryptByPrivateKey,
  RSAEncryptByPrivateKey,
  RSADecryptByPublicKey
}
