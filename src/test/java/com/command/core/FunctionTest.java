package com.command.core;

import com.command.Session;
import com.command.session.LocalSession;
import com.command.session.RemoteSession;
import com.common.Database;
import com.common.Table;
import org.junit.Test;

/**
 * @ClassName Function
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:35
 * @Version 0.0.1
 **/
public class FunctionTest {

    /**
     * command Main Function Test
     */
    @Test
    public void testFunction() throws Exception {
        // 创建会话
        LocalSession session = new LocalSession("example_session");

        // 创建数据库
        session.createDatabase("example_db");

        // 获取数据库
        Database database = session.getDatabase("example_db");

        // 在数据库中创建表
        database.createTable("users");

        // 获取表
        Table table = database.getTable("users");

        // 添加列和索引
        table.addColumn("id");
        table.addColumn("name");
        table.addIndex("idx_name");

        // 打印会话、数据库、表的信息
        System.out.println("Session ID: " + session.getSessionId());
        System.out.println("Database Name: " + database.getName());
        System.out.println("Table Name: " + table.getName());
        System.out.println("Columns: " + table.getColumns());
        System.out.println("Indexes: " + table.getIndexes());
    }
}
