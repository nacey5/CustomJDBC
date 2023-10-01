package com.command.specific;

/**
 * @ClassName CommandListTest
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:50
 * @Version 0.0.1
 **/
import com.command.CommandList;
import com.command.core.CommandInterface;
import com.command.session.LocalSession;
import com.command.session.RemoteSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CommandListTest {

    @Mock
    private RemoteSession session;

    @Test
    public void testCommandList() {
        // 创建查询命令
        CommandInterface queryCommand = new QueryCommand( "SELECT * FROM test_table",session);
        assertNotNull(queryCommand);

        // 创建更新命令
        CommandInterface updateCommand = new UpdateCommand("UPDATE test_table SET column1 = 42",session);
        assertNotNull(updateCommand);

        // 创建命令列表
        CommandList commandList = new CommandList();
        commandList.addCommand(queryCommand);
        commandList.addCommand(updateCommand);

        // 执行命令列表
        commandList.execute();
        // 在这里添加断言来验证命令列表执行结果
    }
}
