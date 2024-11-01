package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        MarioGame marioGame = new MarioGame();
        SuperContraGame superContra = new SuperContraGame();
        PacmanGame pacManGame = new PacmanGame();

        GameRunner gameRunner = new GameRunner(pacManGame);//이제 게임을 바꿀 때 GameRunner의 코드를 단 하나도 바꿀 필요 없다. "느슨한 결합"
        gameRunner.run();
    }
}
