package com.index.utility;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(StopWatchAspect.class);

    @Around("execution(* com.index.utility.NewsApiItemReader.*(..))")
    public Object profileMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed(); 

        stopWatch.stop();
        
        LOGGER.info("Time taken for {} : {}ms", 
                    joinPoint.getSignature().toShortString(), 
                    stopWatch.getTotalTimeMillis());

        return result;
    }
    
    @Around("execution(* com.index.utility.NewsProcessor.*(..))")
    public Object itemProcessorExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = joinPoint.proceed(); // Proceed with the actual method call

        stopWatch.stop();
        
        LOGGER.info("Time taken for {com.index.utility.NewsProcessor} : {}ms", 
                    joinPoint.getSignature().toShortString(), 
                    stopWatch.getTotalTimeMillis());

        return result;
    }
}
