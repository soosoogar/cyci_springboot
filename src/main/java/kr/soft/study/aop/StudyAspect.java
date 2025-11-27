package kr.soft.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class StudyAspect {

    //execution(접근제어자,패키지.클래스명.메소드명(매개변수 타입)
    @Before("execution(* kr.soft.study.api.StudyController.*(..))")
    public void beforeAOT(JoinPoint joinPoint){
        log.info("===========================BEFORE=============================");
        log.info("type-name:{}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName:{}",joinPoint.getSignature().getName());
    }
    @After("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterAPI(JoinPoint joinPoint){
        log.info("===========================AFTER=============================");
        log.info("type-name:{}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName:{}",joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* kr.soft.study.api.StudyController.*(..))")
    public void afterReturningAPI(JoinPoint joinPoint){
        log.info("===========================AFTER-RETURNING=============================");
        log.info("type-name:{}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName:{}",joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* kr.soft.study.api.StudyController.*(..))",
            throwing = "exception")
    public void afterThrowingAPI(JoinPoint joinPoint, Exception exception){
        log.info("===========================AFTER-TROWING=============================");
        log.info("type-name:{}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName:{}",joinPoint.getSignature().getName());
    }

    @Around("execution(* kr.soft.study.api.StudyController.*(..))")
    public Object afterAroundAPI(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===========================😊Around_Start=============================");
        log.info("type-name:{}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("getName:{}",joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        //년, 월, 일, 시 , 분 이 모든 것을 모두 초로 환산, 21억 이상이므로 long으로 받아올것

        //프로젝트
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("===========================🌹Around_END=============================");
        log.info("class: {}",joinPoint.getSignature().getDeclaringTypeName());
        log.info("method: {}",joinPoint.getSignature().getName());
        log.info("실행시간: {}ms",(end-start));
        return result;
    }
}
