package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //1. SpringContext를 실행
        //JVM안에 SpringContext를 만든다. AnnotationConfigApplicationContext 인스턴스를 생성하고, 인수로 @Configuration클래스를 넣어준다.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //2. Spring이 관리해주었으면 하는 것들을 설정 - 이걸 할 수 있는 방법 중 하나가 @Configuration클래스를 만드는 것. 이 설정파일을 이용해서 SpringContext를 실행한다.
        //HelloWorldConfiguration - @Configuration
        //name - @Bean

        //3. Spring이 관리하는 Bean을 검색
        System.out.println(context.getBean("name"));//빈을 꺼내온다. 빈을 꺼내오는 방법으로는 여러가지가 있지만 여기에서는 빈의 이름을 이용함.
    }
}
