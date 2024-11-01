package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        //우선 이렇게 구조를 짜놓고, 각 클래스들을 구현한다. 지금은 GameRunner가 MarioGame에게 의존하고 있다. 의존관계를 바꿀 수가 없음.
        MarioGame marioGame = new MarioGame();
        GameRunner gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
