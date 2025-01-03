package com.of;

import org.apache.commons.dbcp2.BasicDataSource;

public class TestLibrary {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/testDb");
        dataSource.setUsername("fuck");
        dataSource.setPassword("666888");
    }
}
