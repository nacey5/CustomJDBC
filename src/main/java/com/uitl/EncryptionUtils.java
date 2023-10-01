package com.uitl;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.spec.KeySpec;
import java.util.Base64;
/**
 * @ClassName EncryptionUtils
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 17:12
 * @Version 0.0.1
 **/


public class EncryptionUtils {
    public static final String ENCRYPTION_ALGORITHM = "PBEWithMD5AndDES";
    public static final String ENCRYPTION_SALT = "ps242lc;2"; // 自定义盐值
    public static final int ITERATION_COUNT = 1000;

    public static String encrypt(String data) throws Exception {
        byte[] salt = ENCRYPTION_SALT.getBytes();
        KeySpec keySpec = new PBEKeySpec(ENCRYPTION_SALT.toCharArray(), salt, ITERATION_COUNT);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ENCRYPTION_ALGORITHM);
        SecretKey key = factory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static String decrypt(String encryptedData) throws Exception {
        byte[] salt = ENCRYPTION_SALT.getBytes();
        KeySpec keySpec = new PBEKeySpec(ENCRYPTION_SALT.toCharArray(), salt, ITERATION_COUNT);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ENCRYPTION_ALGORITHM);
        SecretKey key = factory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }
}

