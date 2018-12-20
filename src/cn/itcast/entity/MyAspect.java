package cn.itcast.entity;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		System.out.println("在原来的方法执行前，执行某些操作！");
		Object result = methodInvocation.proceed();
		System.out.println("在原来的方法执行后， 执行某些操作！");
		return result;
	}

}
