package com.example.aop_demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    public LoggingAspect(){
        logger.info("TEST");
    }

    @Pointcut("execution(* *(..))")
    public void everythingMethods(){}

    /**
     * Pointcut: All methods in any service class
     *
     * execution(modifiers? return-type declaring-type? method-name(params) throws?)
     *
     * Breakdown of (execution(* com.example.aop_demo.service.*Service.*(..))
     * - * = any return type
     * - com.example.aop_demo.service = package
     * - *Service = class name ends with "Service"
     * - .* = any method
     * - (..) = any parameters
     *
     */

    @Pointcut("execution(* com.example.aop_demo.service.*Service.*(..))")
    public void serviceLayerMethods(){}

    @Pointcut("execution(* com.example.aop_demo.controller.*Controller.*(..))")
    public void controllerLayerMethods(){}

    // Combined pointcut: Service or controller layer
    @Pointcut("serviceLayerMethods() || controllerLayerMethods()")
    public void applicationLayerMethods(){}


    // @Before - Execute before the target method
    @Before("serviceLayerMethods()")
    public void logMethodEntry(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Entering: {}.{}() with args: {}", className, methodName, Arrays.toString(args));
    }

    // @After - Execute after the target method
    // Logs method exit (regardless of success or exception)
    // This acts like a finally block in try catch
    @After("serviceLayerMethods()")
    public void logMethodExit(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("Exiting: {}.{}() ", className, methodName);
    }

    // @AfterReturning - Executes only on sucessful return

    @AfterReturning(pointcut = "serviceLayerMethods()", returning = "result")
    public void logMethodSucess(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();

        logger.info("SUCCESS: {}() returned: {}", methodName, result);
    }

    // @Around - Wraps around the entire method, it is the most powerful

    // Controls whether the method actually executes

    /**
     * @Around
     *  - can control whether the method executes
     *  - can modify arguments before calling
     *  - can modify the return value
     *  - can handle execeptions
     */

    @Around("controllerLayerMethods()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();

        long startTime = System.currentTimeMillis();
        logger.info("TIMIMG START: {}", methodName);

        try{
            // CRITICAL - proceed() actually executes the target method
            Object result = joinPoint.proceed();

            long executionTime = System.currentTimeMillis() - startTime;

            logger.info("TIMIMG END: {} executed in{} ms: {}", methodName, executionTime);

            return result; // Return the original result

        }catch(Throwable e){
            long executionTime = System.currentTimeMillis() - startTime;
            logger.error("TIMIMG ERROR: {} failed after {} ms: {}", methodName, executionTime, e.getMessage());
            throw e; // re-throw to preserve original behavior
        }
    }


}
