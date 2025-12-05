package com.example.lab8_online_store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DbCheck implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Datasource URL: " + dataSource.getConnection().getMetaData().getURL());
        System.out.println("Datasource username: " + dataSource.getConnection().getMetaData().getUserName());
    }
}
