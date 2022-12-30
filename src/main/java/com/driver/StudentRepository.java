package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

	
	private Map<String,Student> studentMap;
	private Map<String,Teacher> teacherMap;
	private Map<String,List<String>> studentTeacherMap ;
	
	
	public StudentRepository() {
		super();
		// TODO Auto-generated constructor stub
	
		   this.studentMap=new HashMap<>();
	        this.teacherMap=new HashMap<>();
	        this.studentTeacherMap=new HashMap<>();
	}



	public void addStudednt(Student student)
	{
	 studentMap.put(student.getName(), student);
	}
	
	
	
	public void addTeacher(Teacher teacher)
	{
	 teacherMap.put(teacher.getName(), teacher); 
	}
	
	
	 public void saveStudentTeacherPair(String studentName, String teacherName){

	        

	        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)){
	            List<String> currentStudentAndTeacher = new ArrayList<>();

	            if(studentTeacherMap.containsKey(teacherName))
	            	currentStudentAndTeacher = studentTeacherMap.get(teacherName);

	            currentStudentAndTeacher.add(studentName);

	            studentTeacherMap.put(teacherName,currentStudentAndTeacher);

	        }

	    }
	 
	 
	 
	    public Student getStudent(String studentName){
	        return studentMap.get(studentName);
	    }

	    public Teacher getTeacher(String teacherName){
	        return teacherMap.get(teacherName);
	    }
	
	
	
	  public List<String> getstudentsByTeacher(String teacherName)
	  {
		  
		  if(studentTeacherMap.containsKey(teacherName))
		 return studentTeacherMap.get(teacherName);
		  
		  return new ArrayList<>();
	  }
	  
	  
	  
	  public List<String> getStudents()
	  {
		
		  return new ArrayList<>(studentMap.keySet());
	  }
	  
	  
	  public void deleteTeacher(String teacherName)
	  {
	        List<String> students = new ArrayList<String>();
	        if(studentTeacherMap.containsKey(teacherName)){
	            //1. Find the student names by director from the pair
	            students = studentTeacherMap.get(teacherName);

	            //2. Deleting all the students from movieDb by using movieName
	            for(String s: students){
	                if(studentMap.containsKey(s)){
	                    studentMap.remove(s);
	                }
	            }

	            //3. Deleteing the pair
	            studentTeacherMap.remove(teacherName);
	        }

	        //4. Delete the teachers from teacherDb.
	        if(teacherMap.containsKey(teacherName)){
	            teacherMap.remove(teacherName);
	        }
		  
	  }
	
	
	  public void deleteAllTeacher()
	  {
		HashSet<String> studentSet = new HashSet<>();
		
		
		for(String teacherName:studentTeacherMap.keySet() )
		{
			for(String studentName :studentTeacherMap.get(teacherName) )
			{
				studentSet.add(studentName);
			}
		}
		
		
		for(String student:studentSet )
		{
			 if(studentMap.containsKey(student)){
	                studentMap.remove(student);
		}
		}
			 
			 
			 studentTeacherMap   = new HashMap<>();
		
	  
	  
		}
	
}
