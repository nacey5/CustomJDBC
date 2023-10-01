package com.command.specific;

import com.command.Command;
import com.command.Session;

/**
 * @ClassName UpdateCommand
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:29
 * @Version 0.0.1
 **/
public class UpdateCommand extends Command {
    public UpdateCommand(String sql, Session session) {
        super(sql, session);
    }

    @Override
    public void execute() {
        // 执行更新操作的具体逻辑
        System.out.println("Executing update: " + sql);
    }
}
