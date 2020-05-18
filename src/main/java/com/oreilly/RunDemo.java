package com.oreilly;

import com.oreilly.entities.Game;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunDemo {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        final Game game = context.getBean("game", Game.class);
        System.out.println(game.playGame());
    }
}
