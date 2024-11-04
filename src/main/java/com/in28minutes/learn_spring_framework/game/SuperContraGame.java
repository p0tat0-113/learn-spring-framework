package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//GamingConsole 인터페이스를 구현함.
@Component
@Qualifier("SuperContraGameQualifier")//한정자
public class SuperContraGame implements GamingConsole {

    //기본적인 조작기능 구현. SupertMario와 같은 메서드이지만 내부 구현이 다르다.
    @Override
    public void up(){
        System.out.println("Up");
    }

    @Override
    public void down(){
        System.out.println("Sit Down");
    }

    @Override
    public void left(){
        System.out.println("Go back");
    }

    @Override
    public void right(){
        System.out.println("Shoot a bullet");
    }
}
