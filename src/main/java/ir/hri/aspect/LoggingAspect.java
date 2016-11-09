package ir.hri.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Before("execution(* ir.hri.business.CustomerBusiness.addCustomer (..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("----- logBefore() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println();
    }

    @After("execution(* ir.hri.business.CustomerBusiness.addCustomer(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("----- logAfter() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println();
    }

    @AfterReturning(
            pointcut = "execution(* ir.hri.business.CustomerBusiness.addCustomerReturnValue(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("----- logAfterReturning() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println();
    }

    @AfterThrowing(
            pointcut = "execution(* ir.hri.business.CustomerBusiness.addCustomerThrowException(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("----- logAfterThrowing() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println();
    }

    @Around("execution(* ir.hri.business.CustomerBusiness.addCustomerAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("----- logAround() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed();
        System.out.println("Around after is running!");

        System.out.println();
    }
}

