package ua.epam.spring.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Map;

@Aspect
public class StatisticsAspect {
    private Map<Class<?>, Integer> counter;

    @Pointcut("execution(* *.logEvent(..) )")
    private void allLogEventMethods() {
    }

    @Around("consoleLoggerMethods()")
    public void aroundLogEvent(ProceedingJoinPoint jp) {
    }

    @Around("consoleLoggerMethods() && args(evt)")
    public void aroundLogEvent(ProceedingJoinPoint jp, Object evt) {

    }



    @AfterReturning("allLogEventMethods()")
    public void count(JoinPoint jp) {
        Class<?> aClass = jp.getTarget().getClass();
        if (!counter.containsKey(aClass)) {
            counter.put(aClass, 0);
        }
        counter.put(aClass, counter.get(aClass) + 1);
    }
}
