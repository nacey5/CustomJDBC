package com.command;

import com.command.session.RemoteSession;
import com.common.Database;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.uitl.EncryptionUtils.*;

/**
 * @ClassName Session
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:26
 * @Version 0.0.1
 **/
public abstract class Session {
    private String sessionId;
    public Map<String, Database> databases;

    protected Session(String sessionId) {
        this.sessionId = sessionId;
        this.databases = new HashMap<>();
    }

    protected String getSessionId() {
        return sessionId;
    }

    protected  Database getDatabase(String databaseName) throws Exception {
        if (this instanceof RemoteSession){
          return   databases.get(decryptDatabaseName(databaseName));
        }
        return databases.get(databaseName);
    }

    protected boolean createDatabase(String databaseName){
        if (!databases.containsKey(databaseName)) {
            Database database = new Database(databaseName);
            databases.put(databaseName, database);
            return true;
        }
        return false;
    }

    private static String decryptDatabaseName(String encryptedDatabaseName) throws Exception {
        byte[] salt = ENCRYPTION_SALT.getBytes();
        KeySpec keySpec = new PBEKeySpec(ENCRYPTION_SALT.toCharArray(), salt, ITERATION_COUNT, 32); // Add KEY_LENGTH parameter
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ENCRYPTION_ALGORITHM);
        SecretKey key = factory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedDatabaseName));
        return new String(decryptedData);
    }

}
