package org.seuge.newsfetcher.aspects.impl;

import jdk.nashorn.internal.runtime.logging.DebugLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.seuge.newsfetcher.aspects.AspectjLoggingAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Slf4jLoggerImpl
 * @author Eugene
 *         Date     10.02.2016
 */
@Aspect
@Service
public class Slf4JAspectjLoggingAspectImpl implements AspectjLoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugLogger.class);

    private static final String METHOD_INTO = "INTO";
    private static final String METHOD_OUT_OF = "OUT OF";
    private static final String METHOD_THREW_OUT = "THREW OUT";
    private static final String DETAILS_PARAMS = "params";
    private static final String DETAILS_PARAM_DEFAULT_NAME = "param";
    private static final String DETAILS_RETURNING = "returning";
    private static final String DETAILS_THROWING = "throwing";

    @Pointcut("execution(* org.seuge.newsfetcher.controllers..*(..)) ||" +
                  "execution(* org.seuge.newsfetcher.dao..*(..)) ||" +
                  "execution(* org.seuge.newsfetcher.services..*(..)) ||" +
                  "execution(* org.seuge.newsfetcher.util..*(..))")
    public void pointcutHolder() {
    }

    @Before(value = "pointcutHolder()")
    public void beforeMethod(JoinPoint joinPoint) {
        try {
            Signature method = joinPoint.getSignature();
            String[] methodParamNames = ((MethodSignature) method).getParameterNames();
            Object[] methodArgValues = joinPoint.getArgs();
            if (methodParamNames == null) {
                methodParamNames = new String[methodArgValues.length];
                for (int i = 0; i < methodArgValues.length; i++) {
                    methodParamNames[i] = DETAILS_PARAM_DEFAULT_NAME + i;
                }
            }
            StringBuilder methodInfo = new StringBuilder();
            methodInfo.append(METHOD_INTO);
            methodInfo.append(": ");
            methodInfo.append(method.getDeclaringType().getSimpleName());
            methodInfo.append("#");
            methodInfo.append(method.getName());
            methodInfo.append("\t");
            methodInfo.append(DETAILS_PARAMS);
            methodInfo.append(": ");
            for (int i = 0; i < methodParamNames.length; i++) {
                methodInfo.append(methodParamNames[i]);
                methodInfo.append("=");
                methodInfo.append(methodArgValues[i]);
                methodInfo.append("; ");
            }
            LOGGER.info(methodInfo.toString());
        } catch (Exception e) {
            LOGGER.warn("Exception on logging attempt: {}", e);
        }
    }

    @AfterReturning(value = "pointcutHolder()", returning = "result")
    public void afterMethodReturning(JoinPoint joinPoint, Object result) {
        try {
            Signature method = joinPoint.getSignature();
            StringBuilder methodInfo = new StringBuilder();
            methodInfo.append(METHOD_OUT_OF);
            methodInfo.append(": ");
            methodInfo.append(method.getDeclaringType().getSimpleName());
            methodInfo.append("#");
            methodInfo.append(method.getName());
            methodInfo.append("\t");
            methodInfo.append(DETAILS_RETURNING);
            methodInfo.append(": ");
            methodInfo.append(result);
            LOGGER.info(methodInfo.toString());
        } catch (Exception e) {
            LOGGER.warn("Exception on logging attempt: {}", e);
        }
    }

    @AfterThrowing(value = "pointcutHolder()", throwing = "throwable")
    public void afterMethodThrowing(JoinPoint joinPoint, Throwable throwable) {
        try {
            Signature method = joinPoint.getSignature();
            StringBuilder methodInfo = new StringBuilder();
            methodInfo.append(METHOD_THREW_OUT);
            methodInfo.append(": ");
            methodInfo.append(method.getDeclaringType().getSimpleName());
            methodInfo.append("#");
            methodInfo.append(method.getName());
            methodInfo.append("\t");
            methodInfo.append(DETAILS_THROWING);
            methodInfo.append(": ");
            methodInfo.append(throwable.getClass());
            methodInfo.append(": ");
            methodInfo.append(throwable.getLocalizedMessage());
            LOGGER.info(methodInfo.toString());
        } catch (Exception e) {
            LOGGER.warn("Exception on logging attempt: {}", e);
        }
    }
}
