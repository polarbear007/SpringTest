package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Target;

// 自动 aop 编程，引入了aspectj 框架和标签，我们可以通过 切入点表达式来选择 对哪个包下的哪个类的哪个方法 进行什么样的加强
// 相比半自动  aop 编程的最大优势就在于此，我们可以只通过少量的配置，就完成对多个代理对象的
// 半自动 aop 编程，你必须要一个代理对象一个 bean 标签去配置，很烦

public class SpringDemo5 {
	@Test
	public void testAOP1() {
		String xmlPath = "applicationContext3.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		Target proxyBean = (Target)context.getBean("targetImpl");
		proxyBean.test();
		context.close();
		
	}
}
