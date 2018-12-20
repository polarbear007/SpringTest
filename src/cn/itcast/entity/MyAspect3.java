package cn.itcast.entity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect3 {
	// 如果我们要使用注解开发，那么我们最好建立一个空的方法, 然后在这个方法上加 @pointcut 注解
	// 那么这个方法的方法名就会成为这个切入点表达式的id ，被其他注解引用
	@Pointcut("execution(* cn.itcast.entity.*.*(..))")
	public void pointcut() {};
	
	@Before(value="pointcut()")
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "方法执行前， before方法先执行了！！！");
	}
	
	@Around(value="pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println(joinPoint.getSignature().getName() + "方法执行前， around 方法先执行某些操作！！");
		Object result = joinPoint.proceed(joinPoint.getArgs());
		System.out.println(joinPoint.getSignature().getName() + "方法执行后，return 前， around 方法再执行一些后续操作！！");
		return result;
	}
	
	@AfterThrowing(value="pointcut()", throwing="e")
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println(joinPoint.getSignature().getName() + "方法在执行过程中抛异常了，异常信息是：" + e.getMessage());
	}
	
	@AfterReturning(value="pointcut()", returning="returning")
	public void afterReturning(JoinPoint joinPoint, Object returning) {
		System.out.println(joinPoint.getSignature().getName() + "方法return 以后，返回值是：" + returning);
	}
	
	@After(value="pointcut()")
	public void after(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "方法最终通知！！！");
	}
}
