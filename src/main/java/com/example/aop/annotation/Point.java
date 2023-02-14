package com.example.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Point {
    Type type();

    enum Type{
        CREATE,
        DELETE
    }
}

/*
  Target = 어디에 선언 할 것인지 설정 : 필드, 메소드, 클래스, 파라미터 등
  Retention = 어느 시점까지 어노테이션이 메모리를 가져갈지 설정
  - SOURCE : 어노테이션을 사실상 주석처럼 사용하는 것
             컴파일러가 컴파일할때 해당 어노테이션의 메모리를 버림
  - CLASS : 컴파일러가 컴파일에서는 어노테이션의 메모리를 가져가지만 실질적으로 런타임시에는 사라지게 됨
            런타임시에 사라진다는 것은 리플렉션으로 선언된 어노테이션 데이터를 가져올 수 없게 된다는 것을 의미. 디폴트값
  - RUNTIME : 어노테이션을 런타임시에까지 사용 가능
              JVM 이 자바 바이트코드가 담긴 class 파일에서 런타임환경을 구성하고 런타임을 종료할 때까지 메모리는 살아있음
 */