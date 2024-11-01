package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*record는 JDK 16에서 도입된 새로운 클래스 형태로, 불변(immutable) 데이터 객체를 간결하게 정의할 수 있게 해줍니다.
record는 주로 데이터를 담기 위한 객체를 만들 때 사용되며, 자동으로 생성되는 메서드들 덕분에 코드의 간결성과 가독성을 크게 향상시킵니다.
필드, 생성자, getter, equals(), hashCode(), toString() 메서드를 자동으로 생성해줍니다. 따라서 개발자가 반복적으로 작성해야 하는 보일러플레이트 코드를 줄일 수 있습니다.*/
record Person(String name, int age){};
record Address(String firstLine, String city){};

@Configuration//@Configuration 애노테이션을 붙여서 설정 클래스로 만든다.
public class HelloWorldConfiguration {
    //여기에서 스프링 빈을 정의할 수 있다. 스프링에서 관리하는 것들을 스프링 빈이라고 함.

    //이 메서드는 스프링 빈을 생성하며, 이 빈은 SpringContainer가 관리한다. SpringContext와의 관계는 나중에 설명한다고 한다.
    @Bean
    public String name() {//스프링에서 관리하는 이름 객체 생성
        return "Dongwoo";
    }

    @Bean
    public int age() {
        return 15;
    }

    //이제 스프링이 사용자 정의 객체도 관리해 줄 수 있는지 확인해보자. 사용자 정의 객체를 스프링 빈으로 추가한다.
    @Bean
    public Person person() {
        Person person = new Person("Dongwoo", 23);
        /*person.age();
        person.name();//record가 게터를 자동으로 생성해 준 것을 알 수 있다.*/

        return person;
    }

    @Bean
    public Address address() {
        return new Address("강남구", "서울");
    }
}
