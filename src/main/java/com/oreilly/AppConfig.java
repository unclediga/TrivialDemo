package com.oreilly;

import com.oreilly.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.oreilly")
public class AppConfig {
    @Autowired
    DataSource dataSource;
    @Resource
    private Team cubs;
    @Resource
    private Team redSox;


    @Bean
    public Game game(){
        final BaseballGame baseballGame = new BaseballGame(redSox, cubs);
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
}
