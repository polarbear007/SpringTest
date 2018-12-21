package cn.itcast.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.transactionManager.Account;
import cn.itcast.transactionManager.AccountService;

// 演示 spring 的事务管理
public class SpringDemo7 {
	@Test
	public void testAdd() {
		String xmlPath = "applicationContext6.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		AccountService service = context.getBean("accountService", AccountService.class);
		Account fromAccount = service.getAccountById(1);
		Account toAccount = service.getAccountById(2);
		service.transfer(fromAccount, toAccount, 100.0);
		context.close();
	}
}
