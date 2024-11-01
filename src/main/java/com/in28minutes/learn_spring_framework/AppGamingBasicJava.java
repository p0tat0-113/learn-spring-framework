package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        //우선 이렇게 구조를 짜놓고, 각 클래스들을 구현한다. 지금은 GameRunner가 MarioGame에게 의존하고 있다. 의존관계를 바꿀 수가 없음.
        MarioGame marioGame = new MarioGame();
        SuperContraGame superContra = new SuperContraGame();

        GameRunner gameRunner = new GameRunner(superContra);//SuperContraGame을 인수로 넣으면 컴파일 에러가 발생한다. GameRunner는 MarioGame에 의존하고 있기 때문.
        gameRunner.run();
    }
}
