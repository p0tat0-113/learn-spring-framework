package com.in28minutes.learn_spring_framework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
