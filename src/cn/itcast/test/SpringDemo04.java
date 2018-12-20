package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.TargetImpl;

public class SpringDemo04 {
	@Test
	public void testAOP1() {
		String xmlPath = "applicationContext2.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		// 【注意】： 如果使用的是 jdk 动态代理，那么这里一定要使用接口类型来强转，不然会报错,因为jdk 代理对象本质是被代理对象的兄弟
		//         如果是 cglib 代理，那么就没有这样的限制，因为cglib 代理对象是被代理对象的儿子
		TargetImpl proxyBean = (TargetImpl)context.getBean("proxyTargetImpl");
		proxyBean.test();
		context.close();
		
	}
}
