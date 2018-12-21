package cn.itcast.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.jdbcTemplate.Student;
import cn.itcast.jdbcTemplate.StudentService;

// 演示 jdbctemplate 的增删改查
public class SpringDemo6 {
	@Test
	public void testAdd() {
		String xmlPath = "applicationContext5.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		StudentService service = context.getBean("studentService", StudentService.class);
		Student stu = new Student();
		stu.setSid(1);
		stu.setSname("Eric");
		stu.setAge(12);
		service.addStudent(stu);
		context.close();
	}
	
	@Test
	public void testDelete() {
		String xmlPath = "applicationContext5.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		StudentService service = context.getBean("studentService", StudentService.class);
		service.deleteStudentBySid(1);
		context.close();
	}
	
	@Test
	public void testUpdate() {
		String xmlPath = "applicationContext5.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		StudentService service = context.getBean("studentService", StudentService.class);
		Student stu = new Student();
		stu.setSid(3);
		stu.setSname("Eric");
		stu.setAge(12);
		service.updateStudent(stu);
		context.close();
	}
	
	@Test
	public void testFindById() {
		String xmlPath = "applicationContext5.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		StudentService service = context.getBean("studentService", StudentService.class);
		Student stu = service.findBySid(5);
		System.out.println(stu.getSid() + "---" + stu.getSname() + "---" + stu.getAge());
		context.close();
	}
	
	@Test
	public void testFindAll() {
		String xmlPath = "applicationContext5.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		StudentService service = context.getBean("studentService", StudentService.class);
		List<Student> list = service.findAll();
		if(list != null && list.size() != 0) {
			for (Student stu : list) {
				System.out.println(stu.getSid() + "---" + stu.getSname() + "---" + stu.getAge());
			}
		}
		context.close();
	}
	
	@Test
	public void testGetCount() {
		String xmlPath = "applicationContext5.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
		
		StudentService service = context.getBean("studentService", StudentService.class);
		Long count = service.getCount();
		System.out.println(count);
		context.close();
	}
}
