package com.example.aop.aop;

import com.example.aop.annotation.Point;
import com.example.aop.domain.Member;
import com.example.aop.repo.MemberRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class PointAspect {
    private final MemberRepo memberRepo;

//    @Before(value = "execution(* com.example.aop.service.PostService.*(..)) && args(postDto)")
//    public void beforeAdvice(JoinPoint joinPoint, PostDto postDto){
//        System.out.println("before");
//    }
//
//    @AfterReturning(value = "execution(* com.example.aop.service.PostService.*(..)) && args(postDto)")
//    public void afterReturning(JoinPoint joinPoint, PostDto postDto){
//        System.out.println("after");
//    }

//    @Before(value = "@annotation(com.example.aop.annotation.Point) && args(postDto)")
//    public void beforeAdvice(JoinPoint joinPoint, PostDto postDto){
//        System.out.println("before");
//    }

    @AfterReturning(value = "@annotation(com.example.aop.annotation.Point) && args(member, ..)")
    public void plus(JoinPoint joinPoint,Member member) {
//        System.out.println("after");
//        System.out.println("joinPoint Target : " + joinPoint.getTarget());
//        System.out.println("joinPoint Signature : " + joinPoint.getSignature());
//        System.out.println("joinPoint This : " + joinPoint.getThis());
//        System.out.println("joinPoint Kind : " + joinPoint.getKind());
//        System.out.println("joinPoint SourceLocation : " + joinPoint.getSourceLocation());
//        System.out.println("joinPoint StaticPart : " + joinPoint.getStaticPart());
//        System.out.println("joinPoint Args : " + Arrays.toString(joinPoint.getArgs()));
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Point point = methodSignature.getMethod().getAnnotation(Point.class);
        System.out.println("Method signature first value: " + point.firstValue());

        if (point.firstValue().equals("create")){
            member.changePoint(10);
            member.changeCountUp();
            memberRepo.save(member);
        } else if (point.firstValue().equals("delete")) {
            member.changePoint(-10);
            member.changeCountDown();
            memberRepo.save(member);
        }


    }




}
//
//@Component
//@RequiredArgsConstructor
//class Point{
//    private final MemberRepo memberRepo;
//
//}