package service;


import java.util.ArrayList;
import java.util.Arrays; 

import model.Course;
import model.Grade;
import model.Person;
import model.Professor;
import model.Student;
import model.enums.ProfDegree;

public class MainService {

	
	private static ArrayList<Person> allPersons = new ArrayList<Person>();//te var glabat personas, stduentus un profesorus
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	
	public static void main(String[] args) {
	
		//datu tips  nosaukums   = new konstruktors;
		Student      stud1       = new Student();
		Student      stud2       = new Student("Rendijs", "Serna", "121234-45678");
		Student      stud3       = new Student("671547", "Ser2d", null);
		allPersons.add(stud1);
		allPersons.add(stud2);
		allPersons.add(stud3);
		
		
		Professor prof1 = new Professor();
		Professor prof2 = new Professor("Vairis", "Caune", "120914-12121", ProfDegree.phd);
		Professor prof3 = new Professor("Galina", "Hilkevica", "121298-34567", ProfDegree.phd);
		allPersons.addAll(Arrays.asList(prof1, prof2, prof3));
		
				
		System.out.println("Visas personas: " +allPersons);
		
		System.out.println("------STUDENTS-------------");
		for(Person tempP: allPersons) {
			if(tempP instanceof Student) {//parbauda, vai persona ir students
				System.out.println(tempP);
			}
		}
		
		System.out.println("------PROFESSORS-------------");
		for(Person tempP : allPersons) {
			if(tempP  instanceof Professor) {//parbauda, vai persona ir students
				System.out.println(tempP);
			}
		}
		
		
		
		System.out.println("------COURSE-------------");
		Course course1 = new Course();
		Course course2 = new Course("Algoritmu teorija", (byte)3, prof2);
		Course course3 = new Course("Matematiska analize", (byte)6, prof3);
		allCourses.addAll(Arrays.asList(course1, course2, course3));
		System.out.println(allCourses);
		
		System.out.println("-------GRADE-------------");
		Grade gr1 = new Grade();// Janis nopelnija 1 JAVA
		Grade gr2 = new Grade(10, stud2, course1);//Rendijs nopelnija 10 JAVA
		Grade gr3 = new Grade(7, stud2, course2);//Rendijs nopelnija 7 Algoritmu teorija
		allGrades.addAll(Arrays.asList(gr1, gr2, gr3));
		System.out.println(allGrades);
		
		System.out.println("-------CRUD TESTING-------------");
		try
		{
			createStudent("Janis", "Berzins", "090512-23456");
			for(Person tempP: allPersons) {
				if(tempP instanceof Student) {//parbauda, vai persona ir students
					System.out.println(tempP);
				}
			}
			System.out.println(getStudentById(4));//Janis
			System.out.println(updateById(1, "Rendijs", "Jaukais"));//Nomainits Rendija uzvards
			for(Person tempP: allPersons) {
				if(tempP instanceof Student) {//parbauda, vai persona ir students
					System.out.println(tempP);
				}
			}
			deleteById(2);//Tiek izdzest unknown students
			for(Person tempP: allPersons) {
				if(tempP instanceof Student) {//parbauda, vai persona ir students
					System.out.println(tempP);
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("-------FILTER TESTING-------------");
		try
		{
		System.out.println(filterAllProfessorsWithSpecificDegree(ProfDegree.phd));
		
		System.out.println("Rendija videja atzime ir " + calculateAVGgradeForStudent("121234-45678"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//CRUD - C - create, R - retrieve, U - update, D - delete
	
	//C - create student
	public static void createStudent(String inputName, String inputSurname, String inputPersonCode) throws Exception
	{
		//TODO parbaudiet ienakosos paramatrus
		
		for(Person tempS : allPersons) {
			if(tempS instanceof Student &&  tempS.getPersonCode().equals(inputPersonCode)) {
				throw new Exception("Tads students jau eksiste");
			}
		}
		
		Student newStudent = new Student(inputName, inputSurname, inputPersonCode);
		allPersons.add(newStudent);
		
		
	}
	
	//R - retrieve by id
	public static Student getStudentById(long id) throws Exception {
		
		if(id < 0) {
			throw new Exception("Id nevar but negativs");
		}
		
		for(Person tempS : allPersons) {
			if(tempS instanceof Student) {//parbaudam, vai persona ir students
				Student stud = (Student)tempS;//parveidojam atrasoto personu uz Student tipa
				if(stud.getStudId() == id) {
					return stud;
				}
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
		allPersons.remove(studentForDeleting);
	}
	
	
	//izfiltret un atgreizt visus profesorus, kuru degree ir master
	public static ArrayList<Professor> filterAllProfessorsWithSpecificDegree(ProfDegree inputDegree) throws Exception
	{
		if(inputDegree == null) {
			throw new Exception("Neeksistejoss grads");
		}
		ArrayList<Professor> result = new ArrayList<Professor>();
		for(Person tempP: allPersons) {
			if(tempP instanceof Professor) {//vai persona ir Professors
				Professor prof = (Professor)tempP;
			
				if(prof.getDegree().equals(inputDegree)) {
					result.add(prof);
				}
			}
		}
		
		if(result.isEmpty()) {
			throw new Exception("Sistema nav profesori ar " + inputDegree + " gradu");
		}
		
		return result;
	
	}

	public static float calculateAVGgradeForStudent(String personCode) throws Exception {
		if(personCode == null || personCode.isEmpty() || !personCode.matches("[0-9]{6}[-]{1}[0-9]{5}")){
			throw new Exception("Nepareizi ievades dati");
		}
		int count = 0;
		float sum = 0;
		for(Grade tempG : allGrades) {
			if(tempG.getStudent().getPersonCode().equals(personCode)) {
				count++;
				sum = sum + tempG.getGrValue();
			}
		}
		
		if(count == 0) {
			throw new Exception("Studentam ar personas kodu " + personCode + " nav atzimju un tapec nevar aprekinat videjo atzimi");
		}
		
		return (sum/count);
		
		
		//atgriezam videjo vertibu
	}
	
	

}
