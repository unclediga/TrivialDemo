package com.oreilly;

import com.oreilly.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.oreilly")
public class AppConfig {
    @Autowired
    DataSource dataSource;
    @Qualifier("cubs")
    @Autowired
    private Team away;

    @Qualifier("redSox")
    @Autowired
    private Team home;


    @Bean
    public Game game(){
        final BaseballGame baseballGame = new BaseballGame(home, away);
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
}
