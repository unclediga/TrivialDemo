package com.oreilly;

import com.oreilly.config.AppConfig;
import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.xml.parsers.DocumentBuilder;
import java.text.NumberFormat;

public class RunDemo {
    public static void main(String[] args) {
//        final ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Beans count = " + context.getBeanDefinitionCount());
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        final Game game = context.getBean("game", Game.class);
        final Team redSox = context.getBean("redSox", Team.class);
        final Team cubs = context.getBean("cubs", Team.class);
        final Team royals = context.getBean("royals", Team.class);
        game.setAwayTeam(cubs);
        game.setHomeTeam(redSox);
        System.out.println(game);
        System.out.println("winner: " + game.playGame());

        game.setAwayTeam(redSox);
        game.setHomeTeam(royals);
        System.out.println(game);
        System.out.println("winner: " + game.playGame());

    }
}
