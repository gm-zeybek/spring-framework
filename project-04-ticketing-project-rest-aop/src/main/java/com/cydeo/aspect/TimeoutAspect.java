package com.cydeo.aspect;



import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Aspect
@Configuration
@Log4j2
public class TimeoutAspect {

//    Logger log = LoggerFactory.getLogger(LoggingAspect.class);


    @Pointcut("@annotation(com.cydeo.annotation.ExecutionTime)")
    public void anyExecutionTimeAnnotationOperation(){}

    @Around("anyExecutionTimeAnnotationOperation()")
    public Object anyExecutionTimeAnnotationAdvice(ProceedingJoinPoint proceedingJoinPoint){
        Object result;
        Long startingTime = System.currentTimeMillis();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        Long endingTime = System.currentTimeMillis();

        log.info("(Around) -> Timeout: {}, Method: {}, Arguments {}",
                endingTime-startingTime, proceedingJoinPoint.getSignature().toShortString(),
                proceedingJoinPoint.getArgs());
        return result;
    }



}
