package com.common;


import java.util.HashMap;
import java.util.Map;
/**
 * @ClassName Database
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:30
 * @Version 0.0.1
 **/


public class Database {
    private String name;
    private Map<String, Table> tables;

    public Database(String name) {
        this.name = name;
        this.tables = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    public void createTable(String tableName) {
        if (!tables.containsKey(tableName)) {
            Table table = new Table(tableName);
            tables.put(tableName, table);
        }
    }
}

