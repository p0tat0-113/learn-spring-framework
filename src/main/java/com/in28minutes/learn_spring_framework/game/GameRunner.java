package com.in28minutes.learn_spring_framework.game;

public class GameRunner {
    MarioGame game;

    public GameRunner(MarioGame marioGame) {
        this.game = marioGame;
    }

    public void run(){
        System.out.println("Running game: " + game);//이럴 때는 보통 로깅 프레임워크를 사용하는 것이 좋다고 함.

        //MarioGame의 메서드를 호출
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
