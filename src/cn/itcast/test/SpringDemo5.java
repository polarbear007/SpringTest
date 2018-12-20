package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Target;

// 【注意】 使用注解开发 aop 的话， 切面类对象一定不要在配置文件中去配置了，而应该一起使用注解
//  @component
//  @aspect

public class SpringDemo5 {
	@Test
	public void testAOP1() {
		String xmlPath = "applicationContext4.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		Target proxyBean = (Target)context.getBean("targetImpl");
		proxyBean.test();
		context.close();
		
	}
}
