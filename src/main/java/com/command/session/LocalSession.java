package com.command.session;

import com.command.Session;
import com.common.Database;

/**
 * @ClassName LocalSession
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:55
 * @Version 0.0.1
 **/
public class LocalSession extends Session {
    public LocalSession(String sessionId) {
        super(sessionId);
    }

    @Override
    public String getSessionId() {
        return "local_" + super.getSessionId();
    }

    @Override
    public Database getDatabase(String databaseName) throws Exception {
        return super.getDatabase(databaseName);
    }

    @Override
    public boolean createDatabase(String databaseName) {
        return super.createDatabase(databaseName);
    }
}
