package com.andrewsavich.bajter.cartridgerefillservice.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Pointcut("within (@org.springframework.web.bind.annotation.RestController *)")
    public void controllerPointcut() {
    }

    @Pointcut("within(com.andrewsavich.bajter.cartridgerefillservice..*)")
    public void applicationBasePackagePointcut() {
    }

    @After("controllerPointcut()")
    public void logAfterController(JoinPoint joinPoint) {
        logger.info("Controller: {}, method: {}", joinPoint.getSignature().getDeclaringType(),
                joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "applicationBasePackagePointcut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        logger.error("Exception in {}.{}() with cause = {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL");
    }

}
