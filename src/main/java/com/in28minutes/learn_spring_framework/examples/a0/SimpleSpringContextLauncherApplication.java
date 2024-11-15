package com.in28minutes.learn_spring_framework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

//텅 빈 어플리케이션 컨텍스트 런쳐 생성

@Configuration
@ComponentScan//현재 패키지에서 자동으로 컴포넌트 스캔을 하므로, 패키지를 명시적으로 지정해주지 않아도 된다.
public class SimpleSpringContextLauncherApplication {
    //@Bean메서드 모두 제거

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
