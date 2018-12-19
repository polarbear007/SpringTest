package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.BeanLifeCyCle;

public class SpringDemo02 {
	@Test
	public void testBeanLifecycle() {
		String xmlPath = "applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		BeanLifeCyCle bean = context.getBean(BeanLifeCyCle.class);
		bean.test();
		context.close();
	}
}
