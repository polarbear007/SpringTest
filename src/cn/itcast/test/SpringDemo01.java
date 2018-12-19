package cn.itcast.test;

import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Order;
import cn.itcast.entity.Student;

public class SpringDemo01 {
	
	// 演示一下最基本的IOC 和 DI
	// 注入一个普通值
	@Test
	public void testIOC() throws Exception {
		String xmlPath = "applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		Student stu = context.getBean(Student.class);
		System.out.println(stu.getName() + "---" + stu.getAge());
		
		context.close();
	}
	
	//演示一下注入引用值/ 注入集合
	// 【注意】： 这里只是演示一下如何配置bean 和 自动注入参数，以后的开发中，一般我们配置的都是controller / service/ dao
	//          层的对象，这些对象中大部分的属性都是引用值，而不是绝对值
	@Test
	public void testIOC2() throws Exception {
		String xmlPath = "applicationContext.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		Customer customer = context.getBean(Customer.class);
		System.out.println(customer.getName());
		
		Set<Order> set = customer.getOrderSet();
		
		if(set != null) {
			for (Order order : set) {
				System.out.println(order.getOid() + "---" + order.getPrice());
			}
		}
		
		context.close();
	}
}
