package com.in28minutes.learn_spring_framework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        //초기화 로직
        System.out.println("초기화 로직");//"초기화 로직"이 출력되는 것을 통해, 사용자가 빈을 로드하거나, 빈의 메서드를 호출하지 않아도 컨텍스트를 실행시키면 초기화가 바로 자동으로 일어나는 것을 확인할 수 있다.
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.
            //Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
