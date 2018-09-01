package top.aprillie.common.constants;

/**
 * @Author: illure
 * @Description:
 * @Date: Created in 2018/8/30 17:09
 * @Modified By:
 */
public class Constants {

    /**
     * AES 密钥
     */
    public static final String AES_SECRET_KEY = "12345678abcdefgh";

    /**
     * RSA 私钥
     */
    public static final String RSA_PRIVATE_KEY =
            "MIICXQIBAAKBgQDDGNtRfvIidWIspD1Z9SmAY+QGURJOjnT7Lx75FosL+xllIAS9\n" +
                    "rV8ETyVq0X1RoZN/VMfnDwapwfQSbtbHEIOOQ8YyQKPIivDn9bMOFE5drWkwSNpI\n" +
                    "teb25F5ASoM04Wz8aJUsN2UtkXSvhfh4eUzeN7TF+xWSudu0OuPsgXlbXQIDAQAB\n" +
                    "AoGBALET8py5uFSGbqFOQVFRMGYURHdnRlJ/AraqQlabm4E4XAhpU2RF5CQpIjEe\n" +
                    "C7z4BsRf00FpZgbWwA2rBM6RspTp+odg4sk4oUmCDl0oVKxHjod9JOEPPyN0HUZE\n" +
                    "eGrN8uFlJiFpiZJfn7RCzmucAtLmrz9y4q7dn3RE8Mve3YkBAkEA+I3L3YIlqLg0\n" +
                    "D4tnOMbXqeOMby2RhkOfM4IsBrtPLDguEH9VsIOiQIWx2OUBCgOHtNdwQ0dzP+8P\n" +
                    "JBWQXd4HTQJBAMjxFzyLPU1a5i+guet6w8d3C8tMfjjY2fmbHifdPyUyrJpl/vLN\n" +
                    "7+EddDSumFsigZfXDztVZ+WyG1Fq6DMPPFECQCeExAkwDDTLNNvT2lGYq+mDGG0E\n" +
                    "3cJvNfzGkaFwXqI1PH27ATDTfRStLR3DK2sgLI+AQYUw8w4TQGEIXK/QAXECQAcn\n" +
                    "/unbE53TpOsBUF3Ai4RpCvR8juo7Xtfy3EoTKRKMEXWWOFQxXV+pCuBtb2OfgPoF\n" +
                    "YLd+PSsDAtINeqOG4WECQQC6WPYfOPL3LiAdgu8zslCpD65IPF8cYQb3P/Fmm7Rh\n" +
                    "q3PfQyEcq1lj7uLdNY/wDJ0UN+rZ/jSBcdEX/EsihfOL";

    /**
     * RSA 公钥
     */
    public static final String RSA_PUBLIC_KEY =
            "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDGNtRfvIidWIspD1Z9SmAY+QG\n" +
                    "URJOjnT7Lx75FosL+xllIAS9rV8ETyVq0X1RoZN/VMfnDwapwfQSbtbHEIOOQ8Yy\n" +
                    "QKPIivDn9bMOFE5drWkwSNpIteb25F5ASoM04Wz8aJUsN2UtkXSvhfh4eUzeN7TF\n" +
                    "+xWSudu0OuPsgXlbXQIDAQAB";


    /**
     * Response Code
     */
    public static final int RESPONSE_STATUS_OK = 200;

    public static final int RESPONSE_STATUS_INTERNAL_ERROR = 500;


    /**
     * Third Part Login
     */
    public static final String THIRD_PART_LOGIN_STATUS_SUCCESS = "success";

    public static final String THIRD_PART_LOGIN_STATUS_FAILURE = "failure";


    /**
     * Mail
     */
    public static final String MAIL_FROM = "illure_work@foxmail.com";

    public static final String MAIL_SUBJECT = "验证码";


    /**
     * SMS
     */
    public static final String MDSMS_ACCOUNT_SID = "2e36b291539b4baa91b6199cdebd05b5";

    public static final String MDSMS_AUTH_TOKEN = "681b76ba8a3249748747f14264969292";

    public static final String MDSMS_REST_URL = "https://api.miaodiyun.com/20150822";

    public static final String MDSMS_VERIFICATION_CODE_TPLID = "209513871";
}
