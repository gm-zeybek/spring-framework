package com.cydeo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Configuration;

import java.util.List;


@Aspect // aspect annotation convert this into aop class
@Configuration
public class LoggingAspect {


    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
// be careful to import from correct location

    // pointcut (why we use pointcut) to declare expression like (execution/within/around..etc)
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))") // pointcut expression
//    // designations: execution => matching method expression
//    private void pointcut(){} // pointcut signature
//
//    @Before("pointcut()")
//    private void log(){
//        logger.info("Logger info ____________");
//    }
//    combined with pointcut and before hook (why we combine this) to clean and shorter code inside the Before annotation
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))") // why .*(..) it cover all methods in the class
//    private void beforeAdvice(){
//        logger.info("Logger info_________:");
//    }

//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))") // why findById(*) it call findById(arg) in repository
//    private void anyProductRepositoryFindById(){}
//
//    @Before("anyProductRepositoryFindById()")
//    public void beforeCourseRepoOperation(JoinPoint joinPoint){ // why joinPoint it is giving additional methods for args, target and execution etc.
//        logger.info("Before (findBy) => method: {} \targument: {} \ttarget: {}",joinPoint, joinPoint.getArgs(),joinPoint.getTarget());
//    }

    //    @Pointcut("within(com.cydeo.controller..*)") // within controller class/ why ..* it is cover all class in the package with WITHIN
//    private void anyControllerOperation(){}
//    @Pointcut("@within(org.springframework.stereotype.Service)")  // within Service stereoTye or service class why it is for annotation cover
//    private void anyServiceOperation(){}
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    private void anyServiceOrControllerOperation(JoinPoint joinPoint){
//        logger.info("Before () => method: {} argument: {} target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyComponentAnnotation(){
//        logger.info("during annotation__sourceLocation:"); // this is not printing
//    }
//    @Before("anyComponentAnnotation()")
//    private void beforeAnyComponentAnnotation(JoinPoint joinPoint){
//        logger.info("Before () -> method: {} Args: {} Target: {}",joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    private void anyGetCourseOperation() {
//    }

//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result){
//        logger.info("After returning -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
//    }

//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result){
//        logger.info("After returning(List) -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
//    }

//    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
//    private void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
//        logger.info("After Throwing () -> Method: {} Message: {}",joinPoint.getSignature().toShortString(), exception.getMessage());
//    }
//    @After("anyGetCourseOperation()")
//    private void afterGetControllerOperation(JoinPoint joinPoint){
//        logger.info("After final () -> Method: {}",joinPoint.getSignature().toShortString());
//    }
@Pointcut("@annotation(com.cydeo.annotation.Loggable)")
private void anyLoggableMethodOperation(){}

    @Around("anyLoggableMethodOperation()")
    private Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    logger.info("Before () -> loggable {}", proceedingJoinPoint.getSignature().toShortString());
    Object results = proceedingJoinPoint.proceed();
    logger.info("After () -> loggable {} result {}", proceedingJoinPoint.getSignature().toShortString(),results);
    return results;
    }

}
