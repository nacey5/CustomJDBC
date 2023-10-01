package com.command.specific;

import com.command.Command;
import com.command.Session;

/**
 * @ClassName QueryCommand
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:28
 * @Version 0.0.1
 **/
public class QueryCommand extends Command {
    public QueryCommand(String sql, Session session) {
        super(sql, session);
    }

    @Override
    public void execute() {
        // 执行查询操作的具体逻辑
        System.out.println("Executing query: " + sql);
    }
}
