package com.command.session;

import com.command.Session;
import com.common.Database;
import com.uitl.EncryptionUtils;

/**
 * @ClassName RemoteSession
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:56
 * @Version 0.0.1
 **/
public class RemoteSession extends Session {
    public RemoteSession(String sessionId) {
        super(sessionId);
    }

    @Override
    public String getSessionId() {
        return "remote_" + super.getSessionId();
    }

    @Override
    public boolean createDatabase(String databaseName) {
        // 远程加密逻辑
        System.out.println("Encryption successful...");
        // 在这里添加加密代码
        try {
            // 加密数据库名称
            String encryptedDatabaseName = EncryptionUtils.encrypt(databaseName);

            // 远程加密逻辑
            // 在这里使用 encryptedDatabaseName 连接远程服务并创建数据库

            // 返回是否创建成功
            return super.createDatabase(encryptedDatabaseName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Database getDatabase(String databaseName) {
        try {
            // 加密数据库名称
            String encryptedDatabaseName = EncryptionUtils.encrypt(databaseName);

            // 远程加密逻辑
            // 在这里使用 encryptedDatabaseName 连接远程服务

            // 返回实际的数据库
            return super.getDatabase(encryptedDatabaseName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
