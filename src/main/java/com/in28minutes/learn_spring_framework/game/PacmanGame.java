package com.in28minutes.learn_spring_framework.game;

import org.springframework.stereotype.Component;

//Configuration파일에서 @Bean으로 스프링 빈을 정의하지 않고,
//이렇게 @Component 애노테이션을 붙여서 스프링에게 이 클래스의 인스턴스 생성을 요청할 수 있다.
@Component
public class PacmanGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("Go up");
    }

    @Override
    public void down() {
        System.out.println("Go down");
    }

    @Override
    public void left() {
        System.out.println("Go left");
    }

    @Override
    public void right() {
        System.out.println("Go right");
    }
}
