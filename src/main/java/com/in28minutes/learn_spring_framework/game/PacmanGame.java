package com.in28minutes.learn_spring_framework.game;

import org.springframework.stereotype.Component;

/*
일반적인 스테레오타입: @Component는 특정한 역할을 나타내지 않는 일반적인 빈을 정의할 때 사용됩니다.
스테레오타입 어노테이션의 기반: @Service, @Repository, @Controller 등 다른 스테레오타입 어노테이션들은 모두 @Component를 메타 애노테이션으로 사용합니다. 이는 특정 역할을 나타내지만, 기본적으로는 @Component의 기능을 상속받습니다.
자동 감지: @Component가 붙은 클래스는 @ComponentScan에 의해 자동으로 감지되고 빈으로 등록됩니다.
*/

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
