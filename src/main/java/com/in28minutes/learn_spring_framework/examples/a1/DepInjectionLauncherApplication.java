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

    //@AutoWired //생성자 주입은 @AutoWired를 꼭 붙이지 않아도 된다. 스프링이 자동으로 생성자를 통해 의존성을 주입한다. 앞에서 별도의 Configuration파일을 만들어서 기존의 스프링 빈을 이용해 새로운 스프링 빈을 만들때 이런 방법을 사용했음.
    //스프링에서는 생성자 주입을 권장한다고 한다. 모든 의존성 주입이 하나의 메서드에서 일어나기 때문.
    public YourBusinessClass(Dependency1 dependency1, Dependency1 dependency2) {
        System.out.println("Constructor Injection - YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    /*//setter를 통한 의존성 주입. setter메서드 앞에 @AutoWired를 붙여주면 된다.
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setter Injection - setDependency1");
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency1 dependency2) {
        System.out.println("Setter Injection - setDependency2");
        this.dependency2 = dependency2;
    }*/

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
