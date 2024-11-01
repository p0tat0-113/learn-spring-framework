package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //try - with - resources 문을 사용해서 리팩토링. 전에 배웠지만, 예외 발생시 자동으로 빠르게 리소스를 반환해준다.

        //1. SpringContext를 실행
        //JVM안에 SpringContext를 만든다. AnnotationConfigApplicationContext 인스턴스를 생성하고, 인수로 @Configuration클래스를 넣어준다.
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
            //2. Spring이 관리해주었으면 하는 것들을 설정 - 이걸 할 수 있는 방법 중 하나가 @Configuration클래스를 만드는 것. 이 설정파일을 이용해서 SpringContext를 실행한다.
            //HelloWorldConfiguration - @Configuration
            //name - @Bean

            //3. Spring이 관리하는 Bean을 검색
            System.out.println(context.getBean("name"));//빈을 꺼내온다. 빈을 꺼내오는 방법으로는 여러가지가 있지만 여기에서는 빈의 이름을 이용함.
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("person4Parameters"));
            System.out.println(context.getBean("person5Qualifier"));
            System.out.println(context.getBean("address2"));

            System.out.println(context.getBean(Address.class));//이름 대신 클래스 정보를 이용해서 Bean을 검색할 수 있다. 현재 Address타입 빈이 2개가 등록되어 있어서 예외가 발생함. 이제 address2 스프링 빈을 기본으로 사용하도록 @Primary를 붙여서 잘 작동함.
            System.out.println(context.getBean(Person.class));

            //SpringContatiner에 등록된 모든 SpringBean들을 나열해보자. Configuration파일과 그 안에서 정의한 스프링 빈들의 이름이 출력된다.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);//함수형 프로그래밍, 메서드 참조, getBeanDefinitionNames()은 String배열을 반환한다.
        }
    }
}
