package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("package com.in28minutes.learn_spring_framework.game")//Configuration파일에 컴포넌트를 어디에서 스캔해야할지 알려준다.
public class GamingAppLauncherApplication {
    //@Bean메서드 모두 제거

    public static void main(String[] args) {
        //1. SpringContext 실행
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.

            context.getBean(GameRunner.class).run();//스프링 빈으로 등록된 GameRunner를 꺼내와서 run()메서드를 호출한다. 스프링이 Configuration파일을 읽고 의존성을 주입해줬기 때문에 게임이 실행된다.
        }
    }
}
