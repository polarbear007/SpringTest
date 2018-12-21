package cn.itcast.jdbcTemplate;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StudentDao extends JdbcDaoSupport{
	// 添加一个学生
	public void addStudent(Student stu) {
		this.getJdbcTemplate().update("insert into t_student values(?, ?, ?)", 
										stu.getSid(), stu.getSname(), stu.getAge());
	}
	
	// 删除一个学生
	public void deleteStudentBySid(Integer sid) {
		this.getJdbcTemplate().update("delete from t_student where sid = ?", sid);
	}
	
	// 根据id 修改一个学生的信息
	public void updateStudent(Student stu) {
		this.getJdbcTemplate().update("update t_student set sname = ? , age = ? where sid = ?",
										stu.getSname(), stu.getAge(), stu.getSid());
	}
	
	// 根据 id 查询一个学生的信息
	public Student findBySid(Integer sid) {
		Student student = this.getJdbcTemplate().queryForObject("select * from t_student where sid = ?",
					new BeanPropertyRowMapper<Student>(Student.class), sid);
		return student;
	}
	
	// 查询所有的学生信息
	public List<Student> findAll() {
		List<Student> list = this.getJdbcTemplate().query("select * from t_student", 
				new BeanPropertyRowMapper<Student>(Student.class));
		return list;
	}
	
	// 聚合查询
	public Long getCount() {
		Long count = this.getJdbcTemplate().queryForObject("select count(*) from t_student", Long.class);
		return count;
	}
}
