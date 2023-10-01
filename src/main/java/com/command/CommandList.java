package com.command;

import com.command.core.CommandInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CommandList
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:29
 * @Version 0.0.1
 **/
public class CommandList implements CommandInterface {
    private List<CommandInterface> commands = new ArrayList<>();

    public void addCommand(CommandInterface command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (CommandInterface command : commands) {
            command.execute();
        }
    }
}
