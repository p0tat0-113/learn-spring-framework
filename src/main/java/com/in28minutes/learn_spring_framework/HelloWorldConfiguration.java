package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*record는 JDK 16에서 도입된 새로운 클래스 형태로, 불변(immutable) 데이터 객체를 간결하게 정의할 수 있게 해줍니다.
record는 주로 데이터를 담기 위한 객체를 만들 때 사용되며, 자동으로 생성되는 메서드들 덕분에 코드의 간결성과 가독성을 크게 향상시킵니다.
필드, 생성자, getter, equals(), hashCode(), toString() 메서드를 자동으로 생성해줍니다. 따라서 개발자가 반복적으로 작성해야 하는 보일러플레이트 코드를 줄일 수 있습니다.*/
record Person(String name, int age, Address address){};
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
        Person person = new Person("Dongwoo", 23, new Address("월스트리트", "뉴욕")); //<- 이 경우에는 새로운 Address객체를 생성해서 넣어주게 된다. 이 부분은 새로운 스프링 빈을 생성해서 넣어주는게 아니라 person 스프링 빈을 생성하는데 사용되는 일회성 객체일 뿐이다.
        /*person.age();
        person.name();//record가 게터를 자동으로 생성해 준 것을 알 수 있다.*/
        return person;
    }

    //person2 Bean을 만든다. 그런데 이번에는 인수로 이미 등록되어 있는 name과 age를 넣고 싶다. 객체간의 관계를 만들어 보려는 것이다.
    //다시말해 기존 스프링 빈과 관계가 있는 새로운 스프링 빈을 만드려고 하는 것이다. 여기에는 2가지 방법이 있다.

    //1. 첫번째는 그냥 메서드를 호출하는 것이다.
    /*@Configuration 어노테이션의 역할:
    @Configuration이 붙은 클래스는 스프링에 의해 특수한 프록시 객체로 처리됩니다. 이 프록시 객체는 빈 메서드 호출을 가로채서 스프링 컨테이너에 등록된 빈을 반환하도록 합니다.
    따라서, 같은 @Configuration 클래스 내에서 @Bean 메서드를 직접 호출하더라도 새로운 인스턴스를 생성하지 않고, 이미 스프링 컨테이너에 등록된 빈을 반환하게 됩니다.

    person2MethodCall 메서드의 동작:
    person2MethodCall 메서드에서 name(), age(), address() 메서드를 호출합니다.
    이 호출들은 스프링 컨테이너에 이미 등록된 빈을 반환합니다.
    name()은 "Dongwoo"라는 String 빈을 반환합니다.
    age()는 15라는 int 빈을 반환합니다.
    address()는 @Bean(name = "address2")로 등록된 Address 빈을 반환합니다.*/

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address()); //<- 이 경우에는 기존에 스프링에 등록되어 있던 Address빈을 가져다 쓰게 된다. 스프링에서 관리하는 기존 빈을 재활용
    }

    //2. 이번에는 매개변수를 사용, 스프링에 등록된 빈들을 가져와서 연결시킨다.
    @Bean
    public Person person3Parameters(String name, int age, Address address3) {//name, age, address3 <- 빈의 이름이 address3이기 때문에 address3를 사용. 매개변수들의 이름은 스프링에 등록된 Bean의 이름과 같아야 한다.
        return new Person(name, age, address3); //<- 이 경우에는 기존에 스프링에 등록되어 있던 Address빈을 가져다 쓰게 된다. 스프링에서 관리하는 기존 빈을 재활용
    }

    @Bean(name = "address2")//이렇게 스프링 빈의 이름을 바꿀 수 있다고 한다.
    public Address address() {
        return new Address("강남구", "서울");
    }

    @Bean(name = "address3")//이렇게 스프링 빈의 이름을 바꿀 수 있다고 한다.
    public Address address3() {
        return new Address("구로구", "서울");
    }
}
