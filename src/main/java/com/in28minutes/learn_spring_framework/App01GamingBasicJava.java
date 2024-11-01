package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

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
