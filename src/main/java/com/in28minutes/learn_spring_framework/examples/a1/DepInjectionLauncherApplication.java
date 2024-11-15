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
    Dependency1 dependency1;
    Dependency1 dependency2;

    //setter를 통한 의존성 주입. setter메서드 앞에 @AutoWired를 붙여주면 된다.
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1");
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency1 dependency2) {
        System.out.println("Setter Injection - setDependency2");
        this.dependency2 = dependency2;
    }

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
