package com.common;

import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName Table
 * @Description TODO
 * @Author DaHuangGo
 * @Date 2023/10/1 16:31
 * @Version 0.0.1
 **/


public class Table {
    private String name;
    private List<String> columns;
    private List<String> indexes;

    public Table(String name) {
        this.name = name;
        this.columns = new ArrayList<>();
        this.indexes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<String> getIndexes() {
        return indexes;
    }

    public void addColumn(String columnName) {
        columns.add(columnName);
    }

    public void addIndex(String indexName) {
        indexes.add(indexName);
    }
}

