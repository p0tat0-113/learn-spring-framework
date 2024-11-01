package com.in28minutes.learn_spring_framework.game;

public class MarioGame {
    //기본적인 조작기능 구현
    public void up(){
        System.out.println("Jump");
    }

    public void down(){
        System.out.println("Go into a hole");
    }

    public void left(){
        System.out.println("Go back");
    }

    public void right(){
        System.out.println("Accelerate");
    }
}
