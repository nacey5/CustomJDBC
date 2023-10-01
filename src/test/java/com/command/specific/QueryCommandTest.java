package com.command.specific;

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
public class QueryCommandTest {



    @Mock
    private RemoteSession session;

    @Test
    public void testQueryCommand() {
        // 创建查询命令
        CommandInterface queryCommand = new QueryCommand("SELECT * FROM test_table",session);
        assertNotNull(queryCommand);

        // 执行查询命令
        queryCommand.execute();
    }


}
