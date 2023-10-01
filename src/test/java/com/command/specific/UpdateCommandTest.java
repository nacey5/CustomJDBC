package com.command.specific;

/**
 * @ClassName UpdateCommandTest
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:49
 * @Version 0.0.1
 **/

import com.command.Session;
import com.command.core.CommandInterface;
import com.command.session.LocalSession;
import com.command.session.RemoteSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCommandTest {

    @Mock
    private RemoteSession session;

    @Test
    public void testQueryCommand() {
        // 创建查询命令
        CommandInterface updateCommand = new UpdateCommand("UPDATE test_table SET column1 = 42",session);
        assertNotNull(updateCommand);

        // 执行查询命令
        updateCommand.execute();
    }
}
