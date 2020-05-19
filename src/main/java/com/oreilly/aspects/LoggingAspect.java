package com.oreilly.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Before("execution(void com.oreilly..*.set*(*))")
    public void callSetters(JoinPoint joinPoint) {
        logger.info("Called " + joinPoint.getSignature().getName() +
                " with args " + joinPoint.getArgs()[0].toString() +
                " on " + joinPoint.getTarget());
    }

    @Around("execution(String playGame())")
    public Object checkForRain(ProceedingJoinPoint point) throws Throwable {
        boolean rain = Math.random() < 0.5;
        Object result = null;
        if (rain) {
            logger.info("Game [" + point.getTarget() + "] rained out");
        } else {
            result = point.proceed();
            logger.info("Game [" + point.getTarget() + "] with winner: " + result);
        }
        return result;
    }
}
