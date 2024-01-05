package com.cydeo.aspect;

import com.cydeo.dto.ProjectDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.keycloak.adapters.springsecurity.account.SimpleKeycloakAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
@Configuration
public class LoggingAspect {

    /*
    Requirement:
    Given User login
    When send request one of controller class methods
    Then user should be logged in console
     */
    Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    private String getUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SimpleKeycloakAccount details = (SimpleKeycloakAccount) authentication.getDetails();
        return details.getKeycloakSecurityContext().getToken().getPreferredUsername();
    }
    @Pointcut("execution(* com.cydeo.controller.ProjectController.*(..)) || execution(* com.cydeo.controller.TaskController.*(..))")
    public void anyControllerOperation(){}

    @Before("anyControllerOperation()")
    public void beforeAnyControllerOperationAdvice(JoinPoint joinPoint){
        log.info("Before () -> User: {}, Method: {}, Argument: {}"
                ,getUserName(), joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "anyControllerOperation()", returning = "results")
    public void afterAnyControllerOperation(JoinPoint joinPoint, Object results){
        log.info("(After Returning) -> username: {}, Method: {}, Argument: {}",
                getUserName(), joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "anyControllerOperation()", throwing = "exception")
    public void afterThrowingAnyControllerOperation(JoinPoint joinPoint, RuntimeException exception){
        log.info("(After Throwing) -> userName: {}, Method: {}, Exception: {}",
                getUserName(), joinPoint.getSignature().toShortString(), exception.getMessage());
    }

}


