package edu.mum.cs544;


import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {
  private static Logger logger = LogManager.getLogger(LogAspect.class.getName());

  @After("execution(* sendEmail(..))")
  public void logAfter(JoinPoint j) throws Throwable {
    IEmailSender t = (IEmailSender) j.getTarget();
    Object[] agrs = j.getArgs();
    System.out.println(new Date() + " method= " + j.getSignature().getName()
        + " \naddress=" + agrs[0] + " \nmessage=" + agrs[1] + " \noutgoing mail server=" + t.getOutgoingMailServer());
  }

  @Around("@within(org.springframework.stereotype.Repository)")
  public Object logAround(ProceedingJoinPoint j) throws Throwable {
    StopWatch sw = new StopWatch();
    sw.start();
    Object r = j.proceed();
    sw.stop();
    System.out.println("Time to execute " + j.getSignature().getName() + ": " + sw.getLastTaskTimeMillis() + " ms");
    return r;
  }

}