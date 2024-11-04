package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//MarioGame도 GamingConsole을 구현
@Component
@Primary//우선권을 줌. 여러 빈에 @Primary를 지정할 경우, 스프링은 예외를 발생시킵니다. 즉, @Primary는 하나의 빈에만 지정해야 합니다.
public class MarioGame implements GamingConsole{
    //기본적인 조작기능 구현
    @Override
    public void up(){
        System.out.println("Jump");
    }

    @Override
    public void down(){
        System.out.println("Go into a hole");
    }

    @Override
    public void left(){
        System.out.println("Go back");
    }

    @Override
    public void right(){
        System.out.println("Accelerate");
    }
}
