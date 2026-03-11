package service;


import model.Course;
import model.Grade;
import model.Professor;
import model.Student;
import model.enums.ProfDegree;

public class MainService {

	public static void main(String[] args) {
		System.out.println("----STUDENTS-------------");
		//datu tips  nosaukums   = new konstruktors;
		Student      stud1       = new Student();
		System.out.println(stud1);
		Student      stud2       = new Student("Rendijs", "Serna", "121234-45678");
		System.out.println(stud2);
		Student      stud3       = new Student("671547", "Ser2d", null);
		System.out.println(stud3);
		
		System.out.println("----PROFESSORS-------------");
		Professor prof1 = new Professor();
		System.out.println(prof1);
		Professor prof2 = new Professor("Vairis", "Caune", "120914-12121", ProfDegree.phd);
		System.out.println(prof2);
		Professor prof3 = new Professor("Galina", "Hilkevica", "121298-34567", ProfDegree.phd);
		System.out.println(prof3);
		
		System.out.println("----COURSE-------------");
		Course course1 = new Course();
		System.out.println(course1);
		Course course2 = new Course("Algoritmu teorija", (byte)3, prof2);
		System.out.println(course2);
		Course course3 = new Course("Matematiska analize", (byte)6, prof3);
		System.out.println(course3);
		
		System.out.println("----GRADE-------------");
		Grade gr1 = new Grade();// Janis nopelnija 1 JAVA
		System.out.println(gr1);
		Grade gr2 = new Grade(10, stud2, course1);//Rendijs nopelnija 10 JAVA
		System.out.println(gr2);
		Grade gr3 = new Grade(7, stud2, course2);//Rendijs nopelnija 7 Algoritmu teorija
		System.out.println(gr3);
		
	}

}
