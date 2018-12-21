package cn.itcast.jdbcTemplate;

import java.util.List;

public class StudentService {
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void addStudent(Student stu) {
		studentDao.addStudent(stu);
	}
	
	public void deleteStudentBySid(Integer sid) {
		studentDao.deleteStudentBySid(sid);
	}
	
	public void updateStudent(Student stu) {
		studentDao.updateStudent(stu);
	}
	
	public Student findBySid(Integer sid) {
		return studentDao.findBySid(sid);
	}
	
	public List<Student> findAll(){
		return studentDao.findAll();
	}
	
	public Long getCount() {
		return studentDao.getCount();
	}
}
