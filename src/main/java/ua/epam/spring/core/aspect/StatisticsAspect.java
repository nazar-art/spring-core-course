package ua.epam.spring.core.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@EnableAspectJAutoProxy
@Component
public class StatisticsAspect {
    private Map<Class<?>, Integer> counter = new HashMap<>();

    @Pointcut("execution(* *.logEvent(..) )")
    private void allLogEventMethods() {
    }

//    @Around("consoleLoggerMethods()")
//    public void aroundLogEvent(ProceedingJoinPoint jp) {
//    }
//
//    @Around("consoleLoggerMethods() && args(evt)")
//    public void aroundLogEvent(ProceedingJoinPoint jp, Object evt) {
//
//    }

    @Before("allLogEventMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("BEFORE: "
                + joinPoint.getTarget().getClass().getSimpleName() + " "
                + joinPoint.getSignature().getName());
    }


    @AfterReturning("allLogEventMethods()")
    public void count(JoinPoint jp) {
        Class<?> aClass = jp.getTarget().getClass();
        if (!counter.containsKey(aClass)) {
            counter.put(aClass, 0);
        }
        counter.put(aClass, counter.get(aClass) + 1);
        System.out.println("Updating counter: " + counter.get(aClass));
    }
}
