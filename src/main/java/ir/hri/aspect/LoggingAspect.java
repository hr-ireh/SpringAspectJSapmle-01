package ir.hri.aspect;


import ir.hri.annotation.Loggable;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    //is a advice methods
    //@Before("execution(* ir.hri.business.CustomerBusiness.addCustomer (..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("----- logBefore() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println();
    }

    //is a advice methods
    //@After("execution(* ir.hri.business.CustomerBusiness.addCustomer(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("----- logAfter() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println();
    }

    //advice methods
    @AfterReturning(
            pointcut = "execution(* ir.hri.business.CustomerBusiness.addCustomerReturnValue(..))",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("----- logAfterReturning() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println();
    }

    //is a advice methods
    @AfterThrowing(
            pointcut = "execution(* ir.hri.business.CustomerBusiness.addCustomerThrowException(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        System.out.println("----- logAfterThrowing() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + error);
        System.out.println();
    }

    //is a advice methods
    //@Around("execution(* ir.hri.business.CustomerBusiness.addCustomerAround(..))")
    //@Around("customerPointcut()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("----- logAround() is running! -----");
        System.out.println("getName: " + joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed();
        System.out.println("Around after is running!");

        System.out.println();
    }

    //is a Pointcut
    @Pointcut("execution(* ir.hri.business.CustomerBusiness.addCustomer (..))")
    public void customerPointcut() {
    }

    @Before("args(name)")
    public void logArgs(String name) {
        System.out.println("String argument passed=" + name);
    }

    //@Before("@annotation(ir.hri.annotation.Loggable)")
    public void myAdvice() {
        System.out.println("Executing myAdvice!");
    }

    @Around("execution(* *(..)) &&  @annotation(loggable)")
    public void calculateExecutionTime(ProceedingJoinPoint pjp,
                                       Loggable loggable) throws Throwable {
        pjp.proceed();
        System.out.println(loggable.recordEvent());
    }
}

