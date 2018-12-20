package cn.itcast.entity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect2 {
	public void before(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "方法执行前， before方法先执行了！！！");
	}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println(joinPoint.getSignature().getName() + "方法执行前， around 方法先执行某些操作！！");
		Object result = joinPoint.proceed(joinPoint.getArgs());
		System.out.println(joinPoint.getSignature().getName() + "方法执行后，return 前， around 方法再执行一些后续操作！！");
		return result;
	}
	
	public void afterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println(joinPoint.getSignature().getName() + "方法在执行过程中抛异常了，异常信息是：" + e.getMessage());
	}
	
	public void afterReturning(JoinPoint joinPoint, Object returning) {
		System.out.println(joinPoint.getSignature().getName() + "方法return 以后，返回值是：" + returning);
	}
	
	public void after(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "方法最终通知！！！");
	}
}
