package com.in28minutes.learn_spring_framework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
@Lazy//@Lazy를 붙이니까 아까와는 다르게 ClassB의 어떤 메서드를 사용하려고 할 때가 되어서야 빈이 초기화 된다.
     //@Lazy는 @Component, @Bean이 붙은 곳에 사용할 수 있다.
     //강사 아재는 즉시 초기화를 권장한다고 한다. 즉시 초기화를 사용하면 컨텍스트 시작과 동시에 모든 빈들이 초기화 되기 때문에, 초기화와 관련된 오류를 어플리케이션이 시작될 때 바로 확인할 수 있음.
     //@Lazy는 그리 자주 사용되지 않는다고 함. 상황에 따라서 고려.
     //@Configuration에 @Lazy를 붙이면 그 안의 모든 @Bean메서드들이 지연 초기화된다고 한다.
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        //초기화 로직
        System.out.println("초기화 로직");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("Do Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.
            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("컨텍스트 초기화 완료");

            context.getBean(ClassB.class).doSomething();
        }
    }
}
