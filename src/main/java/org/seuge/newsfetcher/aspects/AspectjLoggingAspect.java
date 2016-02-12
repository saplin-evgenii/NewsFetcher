package org.seuge.newsfetcher.aspects;

import org.aspectj.lang.JoinPoint;

/**
 * General logger interface
 * @author Eugene Date		10.02.2016
 */
public interface AspectjLoggingAspect {

    void beforeMethod(JoinPoint joinInfo);

    void afterMethodReturning(JoinPoint joinInfo, Object result);

    void afterMethodThrowing(JoinPoint joinPoint, Throwable throwable);
}
