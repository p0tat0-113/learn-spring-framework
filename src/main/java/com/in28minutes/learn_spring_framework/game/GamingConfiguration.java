package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game() {//스프링 빈으로 GamingConsole타입의 game을 등록
        return new MarioGame();
    }

    @Bean
    public GameRunner GameRunner(GamingConsole gamingConsole){//스프링이 AutoWiring해준다. 자동으로 의존성을 주입해 줌. 그냥 game()메서드를 다시 호출해도 된다. 자동으로 스프링 컨테이너에 등록된 빈을 가져와서 넣어줌.
        return new GameRunner(gamingConsole);
    }
}
