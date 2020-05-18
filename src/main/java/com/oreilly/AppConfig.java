package com.oreilly;

import com.oreilly.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.oreilly")
public class AppConfig {
    @Autowired
    DataSource dataSource;
    /*
    No qualifying bean of type 'com.oreilly.entities.Team' available:
    expected single matching bean but found 2: cubs,redSox
    @Resource
    private Team away;
    @Resource
    private Team home;
    */

    @Autowired
    List<Team> teams;

    @Bean
    public Game game(){
        final BaseballGame baseballGame = new BaseballGame(teams.get(0), teams.get(1));
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }
}
