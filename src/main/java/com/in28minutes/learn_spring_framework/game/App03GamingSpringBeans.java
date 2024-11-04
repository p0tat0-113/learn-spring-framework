package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {
    public static void main(String[] args) {

        //1. SpringContext 실행
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {//설정파일을 인수로 넣어줌.

            context.getBean(GameRunner.class).run();//스프링 빈으로 등록된 GameRunner를 꺼내와서 run()메서드를 호출한다. 스프링이 Configuration파일을 읽고 의존성을 주입해줬기 때문에 게임이 실행된다.
        }
    }
}
