package com.in28minutes.learn_spring_framework.game;

//MarioGame도 GamingConsole을 구현
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
