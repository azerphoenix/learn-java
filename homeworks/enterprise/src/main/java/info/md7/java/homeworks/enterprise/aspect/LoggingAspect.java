package info.md7.java.homeworks.enterprise.aspect;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Log4j
public class LoggingAspect {

  private static final Map<String, Integer> methodCallsCountMap = new HashMap<>();

  @Pointcut("execution(* info.md7.java.homeworks.enterprise.repository.impl.UserRepositoryImpl.*(..))")
  public void aroundRepositoryPointcut() {
  }

  /*@Before("aroundRepositoryPointcut()")
  public void logBefore(JoinPoint joinPoint) {
      log.info("Method " + joinPoint.getSignature().getName() + " start");
  }*/

  /*@AfterReturning(pointcut = "aroundRepositoryPointcut()")
  public void doAccessCheck(JoinPoint joinPoint) {
      log.info("Method " + joinPoint.getSignature().getName() + " finished");
  }*/

  /*@After("aroundRepositoryPointcut()")
  public void doAccessCheck(JoinPoint joinPoint) {
      log.info("Method " + joinPoint.getSignature().getName() + " finished");
  }*/

  @Around("aroundRepositoryPointcut()")
  public Object logAroundMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
    String key = signature.toString();
    methodCallsCountMap.putIfAbsent(key, 0);
    methodCallsCountMap.put(key, methodCallsCountMap.get(key) + 1);
    log.info("Called method: " + key + " | count: " + methodCallsCountMap.get(key));
    return proceedingJoinPoint.proceed();
  }

}
