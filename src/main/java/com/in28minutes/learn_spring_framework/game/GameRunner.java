package com.in28minutes.learn_spring_framework.game;

//이제 GameRunner는 추상적인 GamingConsole인터페이스에 의존한다.
public class GameRunner {
    private GamingConsole game;

    public GameRunner(GamingConsole game) {
        this.game = game;
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
