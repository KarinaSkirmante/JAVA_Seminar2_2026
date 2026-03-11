package model;

public class Grade {
	//1. mainigie
	private long gradeId;
	private int grValue;
	private Student student;
	private Course course;	
	
	private static long counter = 30000;
	//2. getters

	public long getGradeId() {
		return gradeId;
	}

	public int getGrValue() {
		return grValue;
	}

	public Student getStudent() {
		return student;
	}

	public Course getCourse() {
		return course;
	}

	//3. setters
	public void setGradeId() {
		gradeId = counter;
		counter++;
	}

	public void setGrValue(int inputGrValue) {
		if(inputGrValue >= 1 && inputGrValue <=10) {
			grValue = inputGrValue;
		}
		else
		{
			grValue = 1;
		}
	}

	public void setStudent(Student inputStudent) {
		if(inputStudent!=null) {
			student = inputStudent;
		}
		else
		{
			student = new Student();
		}
	}

	public void setCourse(Course inputCourse) {
		if(inputCourse!=null) {
			course = inputCourse;
		}
		else
		{
			course = new Course();
		}
	}
	

	
	
	//4. bezargumenta konstruktors
	//5.argumenta konstruktors
	//6. toString
	//7. parejas funkcijas
	
}
