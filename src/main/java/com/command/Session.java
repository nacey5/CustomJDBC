package com.command;

import com.command.session.RemoteSession;
import com.common.Database;
import com.uitl.EncryptionUtil;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

//import static com.uitl.EncryptionUtils.*;

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

    protected Database getDatabase(String databaseName) throws Exception {
        if (this instanceof RemoteSession) {
            //todo 解密
            return databases.get("");
        }
        return databases.get(databaseName);
    }

    protected boolean createDatabase(String databaseName) throws Exception {
        if (this instanceof RemoteSession) {
            databaseName = EncryptionUtil.encrypt(databaseName, EncryptionUtil.generateSecretKey());
            return createDatabase0(databaseName);
        }
        return createDatabase0(databaseName);
    }


    private boolean createDatabase0(String databaseName) {
        if (!databases.containsKey(databaseName)) {
            Database database = new Database(databaseName);
            databases.put(databaseName, database);
            return true;
        }
        return false;
    }

}
