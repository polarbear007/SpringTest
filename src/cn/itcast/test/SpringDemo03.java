package cn.itcast.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.itcast.entity.Target;
import cn.itcast.entity.TargetImpl;

// 演示 jdk动态代理 和 cglib 动态代理

public class SpringDemo03 {
	
	// 先演示 jdk 动态代理
	@Test
	public void testJDKProxy() {
		final Target t = new TargetImpl();
		
		Target targetProxy = (Target)Proxy.newProxyInstance(t.getClass().getClassLoader(), 
								t.getClass().getInterfaces(), 
								new InvocationHandler() {
									
									@Override
									public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
										System.out.println("加强功能1");
										Object result = method.invoke(t, args);
										System.out.println("加强功能2");
										return result;
									}
								});
		
		targetProxy.test();
	}
	
	// 演示 cglib 动态代理
	@Test
	public void tsetCglibProxy() {
		final TargetImpl t = new TargetImpl();
		
		// 创建 enhancer 核心类对象
		Enhancer enhancer = new Enhancer();
		
		// 设置被代理对象也可以说是设置父类对象
		enhancer.setSuperclass(t.getClass());
		
		// 设置回调函数
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				System.out.println("加强功能1");
				Object result = method.invoke(t, args);
				System.out.println("加强功能2");
				return result;
			}
		});
		
		// 通过 enhancer 创建代理对象，这个代理对象是被代理对象的子类对象，所以可以强转成被代理对象的类型
		TargetImpl tProxy = (TargetImpl) enhancer.create();
		tProxy.test();
	}
	
	// 演示 cglib 动态代理, 不需要创建被代理对象
		@Test
		public void tsetCglibProxy2() {
			//final TargetImpl t = new TargetImpl();
			
			// 创建 enhancer 核心类对象
			Enhancer enhancer = new Enhancer();
			
			// 设置被代理对象也可以说是设置父类对象
			enhancer.setSuperclass(TargetImpl.class);
			
			// 设置回调函数
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
					System.out.println("加强功能1");
					// 这里我们使用 methodProxy 参数，可以直接通过代理对象调用父类的方法
					// 这样子，我们就不需要事先创建一个父类对象  TargetImpl 
					Object result = methodProxy.invokeSuper(proxy, args);
					System.out.println("加强功能2");
					return result;
				}
			});
			
			// 通过 enhancer 创建代理对象，这个代理对象是被代理对象的子类对象，所以可以强转成被代理对象的类型
			TargetImpl tProxy = (TargetImpl) enhancer.create();
			tProxy.test();
		}
}
