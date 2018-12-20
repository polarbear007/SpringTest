package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Target;

public class SpringDemo04 {
	@Test
	public void testAOP1() {
		String xmlPath = "applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		Target proxyBean = (Target)context.getBean("proxyTargetImpl");
		proxyBean.test();
		context.close();
		
	}
}
