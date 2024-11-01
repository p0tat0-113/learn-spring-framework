package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//@Configuration 애노테이션을 붙여서 설정 클래스로 만든다.
public class HelloWorldConfiguration {
    //여기에서 스프링 빈을 정의할 수 있다. 스프링에서 관리하는 것들을 스프링 빈이라고 함.

    //이 메서드는 스프링 빈을 생성하며, 이 빈은 SpringContainer가 관리한다. SpringContext와의 관계는 나중에 설명한다고 한다.
    @Bean
    public String name() {//스프링에서 관리하는 이름 객체 생성
        return "Dongwoo";
    }
}
