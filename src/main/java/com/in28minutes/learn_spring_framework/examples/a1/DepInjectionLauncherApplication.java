package com.in28minutes.learn_spring_framework.examples.a1;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//생성자 주입 예제를 위한 내부클래스들
@Component
class YourBusinessClass {
    //필드를 통한 의존성 주입. 별도의 생성자나 setter가 없음. 리플렉션을 통해서 의존성이 주입된다.
    @Autowired//@Autowired를 붙여야 Spring이 자동으로 의존성을 주입해준다. 처음에는 @AutoWired를 붙이지 않아서 null이 출력됐었음.
    Dependency1 dependency1;
    @Autowired
    Dependency1 dependency2;

    @Override
    public String toString() {
        return "YourBusinessClass{" +
                "dependency1=" + dependency1 +
                ", dependency2=" + dependency2 +
                '}';
    }
}
@Component
class Dependency1 {

}
@Component
class Dependency2 {

}

@Configuration
@ComponentScan//현재 패키지에서 자동으로 컴포넌트 스캔을 하므로, 패키지를 명시적으로 지정해주지 않아도 된다.
public class DepInjectionLauncherApplication {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
