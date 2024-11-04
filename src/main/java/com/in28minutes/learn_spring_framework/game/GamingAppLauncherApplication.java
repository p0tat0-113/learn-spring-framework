package com.in28minutes.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
@ComponentScan은 스프링이 특정 패키지 내에서 @Component와 그 파생 어노테이션이 붙은 클래스를 자동으로 감지하여 빈으로 등록하도록 지시하는 애노테이션입니다.
이를 통해 개발자는 수동으로 빈을 등록하지 않고도 필요한 클래스들을 빈으로 관리할 수 있습니다.
*/

@Configuration
@ComponentScan("package com.in28minutes.learn_spring_framework.game")//Configuration파일에 컴포넌트를 어디에서 스캔해야할지 알려준다.
public class GamingAppLauncherApplication {
    //@Bean메서드 모두 제거

    public static void main(String[] args) {
        //1. SpringContext 실행
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {//Configure 인수를 이 클래스로 바꿔준다.

            context.getBean(GameRunner.class).run();//스프링 빈으로 등록된 GameRunner를 꺼내와서 run()메서드를 호출한다. 스프링이 Configuration파일을 읽고 의존성을 주입해줬기 때문에 게임이 실행된다.
        }
    }

    /*
    동작 방식
    설정 클래스에 @ComponentScan 선언:
    스프링은 설정 클래스(@Configuration이 붙은 클래스)에 선언된 @ComponentScan을 통해 스캔할 패키지를 파악합니다.

    패키지 내 클래스 검색:
    지정된 패키지와 그 하위 패키지에서 @Component와 그 파생 어노테이션이 붙은 클래스를 검색합니다.

    빈으로 등록:
    검색된 클래스는 스프링 컨테이너에 빈으로 등록됩니다. 빈의 이름은 기본적으로 클래스 이름의 첫 글자를 소문자로 변환한 형태(myComponent)이지만, @Component("customName")처럼 명시적으로 지정할 수도 있습니다.

    의존성 주입:
    등록된 빈들은 다른 빈들 간의 의존성을 주입받을 때 사용됩니다. 예를 들어, @Autowired를 통해 자동으로 주입됩니다.
    */
}
