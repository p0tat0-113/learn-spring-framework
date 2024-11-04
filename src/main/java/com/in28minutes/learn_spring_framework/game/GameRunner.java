package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component//@Component애노테이션 추가, 스프링이 자동으로 인스턴스를 생성해줌. 설정파일에서 @Bean메서드를 정의할 필요 없음.
public class GameRunner {
    private GamingConsole game;

    //생성자 주입, 생성자를 통해 AutoWiring한다.
    public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {//@Qualifier로 특정 스프링 빈에 우선권을 준다. 이 한정자가 AutoWiring되어야 함.
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
