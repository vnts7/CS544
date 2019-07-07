package edu.mum.cs544.bank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import edu.mum.cs544.bank.logging.Logger;

@Aspect
@Component
public class LogAspect {
  @Autowired
  private Logger log;

  @After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
  public void logDao(JoinPoint j) throws Throwable {
    log.log("--------DAO method " + j.getSignature().getName());
  }

  @After("execution(* edu.mum.cs544.bank.jms.*.*(..))")
  public void logJMS(JoinPoint j) throws Throwable {
    log.log("--------JMS method " + j.getSignature().getName());
  }

  // @Around("@within(org.springframework.stereotype.Repository)")
  @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
  public Object logAround(ProceedingJoinPoint j) throws Throwable {
    StopWatch sw = new StopWatch();
    sw.start();
    Object r = j.proceed();
    sw.stop();
    log.log("--------SERVICE Time to execute " + j.getSignature().getName() + ": " + sw.getLastTaskTimeMillis() + " ms");
    return r;
  }

}