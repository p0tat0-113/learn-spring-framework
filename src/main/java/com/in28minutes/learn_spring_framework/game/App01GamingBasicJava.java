package com.in28minutes.learn_spring_framework.game;

public class App01GamingBasicJava {
    public static void main(String[] args) {

        //1. 인스턴스 생성
        MarioGame marioGame = new MarioGame();
        SuperContraGame superContra = new SuperContraGame();
        PacmanGame pacManGame = new PacmanGame();

        GameRunner gameRunner = new GameRunner(pacManGame);//2. 인스턴스 생성 + 의존성 주입
        gameRunner.run();
    }
}
