package com.oreilly;

import com.oreilly.entities.Game;
import com.oreilly.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
//        final ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
        final ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Beans count = " + context.getBeanDefinitionCount());
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        final Game game1 = context.getBean("game", Game.class);
        System.out.println(game1);
        final Game game2 = context.getBean("game", Game.class);
        final Team royals = context.getBean("royals", Team.class);
        game2.setAwayTeam(royals);
        System.out.println(game2);
        System.out.println(game1);
        // game1 = game2, Scope("singleton") default
        // game1 <> game2, Scope("prototype")
    }
}
