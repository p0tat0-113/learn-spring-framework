package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App03GamingSpringBeans {

    //별도로 운용하던 Configuration클래스를 제거. 여기에서 바로 스프링 빈들을 정의하고 컨텍스트를 실행한다.
    @Bean
    public GamingConsole game() {//스프링 빈으로 GamingConsole타입의 game을 등록
        return new MarioGame();
    }

    @Bean
    public GameRunner GameRunner(GamingConsole gamingConsole){//스프링이 AutoWiring해준다. 자동으로 의존성을 주입해 줌. 그냥 game()메서드를 다시 호출해도 된다. 자동으로 스프링 컨테이너에 등록된 빈을 가져와서 넣어줌.
        return new GameRunner(gamingConsole);
    }

    public static void main(String[] args) {
        //1. SpringContext 실행
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {//Configure 인수를 이 클래스로 바꿔준다.

            context.getBean(GameRunner.class).run();//스프링 빈으로 등록된 GameRunner를 꺼내와서 run()메서드를 호출한다. 스프링이 Configuration파일을 읽고 의존성을 주입해줬기 때문에 게임이 실행된다.
        }
    }
}
