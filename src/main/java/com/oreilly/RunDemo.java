package com.oreilly;

import com.oreilly.entities.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
        final ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
//        final AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Beans count = " + context.getBeanDefinitionCount());
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        final Game game = context.getBean("game", Game.class);
        System.out.println(game.playGame());
    }
}
