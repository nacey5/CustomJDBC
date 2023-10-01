package com.command;

import com.command.core.CommandInterface;

/**
 * @ClassName Command
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:24
 * @Version 0.0.1
 **/
public abstract class Command implements CommandInterface {

    protected final String sql;
    protected final Session session;

    public Command(String sql, Session session) {
        this.sql = sql;
        this.session = session;
    }

}
