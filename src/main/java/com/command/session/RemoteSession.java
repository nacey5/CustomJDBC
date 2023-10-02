package com.command.session;

import com.command.Session;
import com.common.Database;

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
            return super.createDatabase(databaseName);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return false;
    }

    @Override
    public Database getDatabase(String databaseName) {
        try {
            return super.getDatabase(databaseName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
