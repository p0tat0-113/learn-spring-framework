package com.in28minutes.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//일반 클래스
@Component
class NormalClass {
    //기본적으로 스프링 프레임워크의 빈들은 모두 "싱글톤"이다.
    //각 스프링 IOC컨테이너에 하나의 인스턴스만 존재할 수 있음.
}

//프로토타입 클래스, @Scope를 붙이고 value를 ConfigurableBeanFactory.SCOPE_PROTOTYPE로 설정했다.
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {
    //Bean을 참조할 때마다 새로운 인스턴스를 얻고 싶으면 "프로토타입"으로 만들면 된다.
    //빈을 요청할 때마다 새로운 인스턴스를 생성한다.
    //각 스프링 IOC컨테이너에 여러개의 인스턴스가 존재할 수 있음.
}

//추가적으로 웹어플리케이션에는 Request Session Application Websocket 같은 스코프도 있다고 한다.
//자바의 디자인패턴에서 얘기하는 싱글톤과 스프링에서 얘기하는 싱글톤은 정의가 약간 다르다고 한다. 전자는 JVM 하나에 인스턴스 하나, 후자는 스프링 IOC컨테이너 하나에 인스턴스 하나
//앞에서 배운 LazyInitialization과는 별개의 개념이라는 것 명심하자. 걔는 그냥 싱글톤 빈의 초기화를 나중에 하는 것 뿐이고, 이건 요청이 들어올 때마다 새로운 인스턴스를 생성하는 것이다.

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.
            //노멀 클래스와 프로토타입 클래스 빈을 3번씩 출력

            System.out.println(context.getBean(NormalClass.class));//노멀 클래스는 3번 다 주소값이 같다.
            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));//context.getBean을 호출할 때 마다 주소값이 다름. 매번 새로운 인스턴스를 얻는다.
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }
    }
}
