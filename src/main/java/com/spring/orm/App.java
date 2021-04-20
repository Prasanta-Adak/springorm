package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
StudentDao studentDao=context.getBean("studentDao", StudentDao.class);
//Student student=new Student(145, "susanta", "howra");
//int r=studentDao.insert(student);
//System.out.println("Done.."+r);
BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
boolean go=true;
while(go) {
System.out.println("Press 1 for add new student");
System.out.println("Press 2 for display all student");
System.out.println("Press 3 for get details for one student");
System.out.println("Press 4 for delete student");
System.out.println("Press 5 for update student");
System.out.println("Press 6 for exit");

try {
	
	int input=Integer.parseInt(bReader.readLine());
//	if(input==1) {
//		//add new Stud
//	}
	switch (input) {
	case 1:
		//add new student
		System.out.println("Enter user id : ");
		int studentId=Integer.parseInt(bReader.readLine());
		
		System.out.println("Enter user name : ");
		String studentName=bReader.readLine();
		
		System.out.println("Enter user city : ");
		String studentCity=bReader.readLine();
		
		Student student=new Student(studentId, studentName, studentCity);
		
		int r=studentDao.insert(student);
		System.out.println(r +" student added");
		System.out.println("**************************************************");
		System.out.println();
		
		
		break;
	case 2:
		//display all student
		List<Student> allStudent = studentDao.getAllStudent();
		System.out.println("**********************************************************************************");
		for(Student st:allStudent) {
			System.out.println(st);
			System.out.println(":--------------");
			System.out.println("Id : "+st.getStudentId());
			System.out.println("Nmae : "+st.getStudentName());
			System.out.println("City : "+st.getStudentCity());
			System.out.println("_________________________________");
		}
		System.out.println("**********************************************************************************");
		break;
	case 3:
		//display single student
		System.out.println("**********************************************************************************");
		System.out.println("Enter student id : ");
		int studentId1=Integer.parseInt(bReader.readLine());
		Student student1 = studentDao.getStudent(studentId1);
		System.out.println("Id : "+student1.getStudentId());
		System.out.println("Nmae : "+student1.getStudentName());
		System.out.println("City : "+student1.getStudentCity());
		System.out.println("**********************************************************************************");
		break;
	case 4:
		//delete student
		System.out.println("**********************************************************************************");
		System.out.println("Enter student id : ");
		int studentId2=Integer.parseInt(bReader.readLine());
		studentDao.deleteStudent(studentId2);
		System.out.println("student with id "+studentId2+" was deleted");
		System.out.println("**********************************************************************************");
		break;
	case 5:
		//update student
		break;
	case 6:
		//exit
		go=false;
		break;
	}
} catch (Exception e) {
	System.out.println("Invalid Input try with another value !!");
	System.out.println(e.getMessage());
}
}
System.out.println("Thank you for using this Application");
System.out.println("!! see you soon !!");
    }
}
