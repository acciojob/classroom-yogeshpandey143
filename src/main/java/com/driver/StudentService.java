package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	
	public void addMyStudent(Student student)
	{
		studentRepository.addStudednt(student);
	}
	
	public void addMyTeacher(Teacher teacher)
	{
		studentRepository.addTeacher(teacher);
	}
	
	
	public void saveStudentTeacher(String studentName,String teacherName)
	{
		studentRepository.saveStudentTeacherPair(studentName, teacherName);
	}
	
	
	public Student getMyStudent(String studentName)
	{
		return studentRepository.getStudent(studentName);
	}
	
	public Teacher getMyTeacher(String teacherName)
	{
		return studentRepository.getTeacher(teacherName);
	}
	
	
	public List<String> getStudentByTeacherName(String teacherName)
	{
	   return studentRepository.getstudentsByTeacher(teacherName);
	   
	}
	
	
	public List<String> getAllStudents()
	{
	   return studentRepository.getStudents();
	   
	}
	
	
	public void deleteTeacherByMyName(String teacherName)
	{
		studentRepository.deleteTeacher(teacherName);
	}
	
	public void deleteAllMyTeachers()
	{
		studentRepository.deleteAllTeacher();
	}
	
}
