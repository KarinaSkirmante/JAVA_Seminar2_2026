package service;


import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.Grade;
import model.Professor;
import model.Student;
import model.enums.ProfDegree;

public class MainService {

	
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	
	public static void main(String[] args) {
		System.out.println("----STUDENTS-------------");
		//datu tips  nosaukums   = new konstruktors;
		Student      stud1       = new Student();
		Student      stud2       = new Student("Rendijs", "Serna", "121234-45678");
		Student      stud3       = new Student("671547", "Ser2d", null);
		allStudents.add(stud1);
		allStudents.add(stud2);
		allStudents.add(stud3);
		
		for(Student tempS : allStudents) {
			System.out.println(tempS);
		}
				
		
		System.out.println("----PROFESSORS-------------");
		Professor prof1 = new Professor();
		Professor prof2 = new Professor("Vairis", "Caune", "120914-12121", ProfDegree.phd);
		Professor prof3 = new Professor("Galina", "Hilkevica", "121298-34567", ProfDegree.phd);
		allProfessors.addAll(Arrays.asList(prof1, prof2, prof3));
		System.out.println(allProfessors);
		
		System.out.println("----COURSE-------------");
		Course course1 = new Course();
		Course course2 = new Course("Algoritmu teorija", (byte)3, prof2);
		Course course3 = new Course("Matematiska analize", (byte)6, prof3);
		allCourses.addAll(Arrays.asList(course1, course2, course3));
		System.out.println(allCourses);
		
		System.out.println("----GRADE-------------");
		Grade gr1 = new Grade();// Janis nopelnija 1 JAVA
		Grade gr2 = new Grade(10, stud2, course1);//Rendijs nopelnija 10 JAVA
		Grade gr3 = new Grade(7, stud2, course2);//Rendijs nopelnija 7 Algoritmu teorija
		allGrades.addAll(Arrays.asList(gr1, gr2, gr3));
		System.out.println(allGrades);
		
		
	}
	
	//CRUD - C - create, R - retrieve, U - update, D - delete
	
	//C - create student
	public static void createStudent(String inputName, String inputSurname, String inputPersonCode) throws Exception
	{
		//TODO parbaudiet ienakosos paramatrus
		
		for(Student tempS : allStudents) {
			if(tempS.getPersonCode().equals(inputPersonCode)) {
				throw new Exception("Tads students jau eksiste");
			}
		}
		
		Student newStudent = new Student(inputName, inputSurname, inputPersonCode);
		allStudents.add(newStudent);
		
		
	}
	
	//R - retrieve by id
	public static Student getStudentById(long id) throws Exception {
		
		if(id < 0) {
			throw new Exception("Id nevar but negativs");
		}
		
		for(Student tempS : allStudents) {
			if(tempS.getStudId() == id) {
				return tempS;
			}
		}
		
		throw new Exception("Students ar id " + id + " neeksiste");
		
	}
	
	//U - update
	public static Student updateById(int id, String inputName, String inputSurname) throws Exception {
		Student studentForUpdating = getStudentById(id);
		
		//TODO parbaudit inputName un inputSurname
		if(!studentForUpdating.getName().equals(inputName)) {
			studentForUpdating.setName(inputName);
		}
		
		if(!studentForUpdating.getSurname().equals(inputSurname)) {
			studentForUpdating.setSurname(inputSurname);
		}
		
		return studentForUpdating;
		
	}
	
	//D - delete
	public static void deleteById(int id) throws Exception{
		Student studentForDeleting = getStudentById(id);
		allStudents.remove(studentForDeleting);
	}
	
	
	
	
	
	
	

}
