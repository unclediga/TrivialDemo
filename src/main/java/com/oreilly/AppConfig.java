package com.oreilly;

import com.oreilly.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.text.NumberFormat;
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

    @Bean @Scope("prototype")
    public Game game(){
        final BaseballGame baseballGame = new BaseballGame(/*not new RedSox()*/redSox(), teams.get(0));
        baseballGame.setDataSource(dataSource);
        return baseballGame;
    }

    @Bean
    public Team redSox(){
        return new RedSox();
    }

    @Bean
    public NumberFormat nf(){
        return NumberFormat.getCurrencyInstance();
    }

    @Bean
    public DocumentBuilder builder() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }
}
