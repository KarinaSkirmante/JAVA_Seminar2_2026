package model;

public class Course {
	//1. mainigie
	private long courseId;
	private String title;
	private byte creditPoints;
	private Professor professor;//TODO izveidot ari esipeju, ka pasniedz vairaki pasniedzeji vienu un to pasu kursu
	
	private static long counter = 20000;
	//2. getters

	public long getCourseId() {
		return courseId;
	}

	public String getTitle() {
		return title;
	}

	public byte getCreditPoints() {
		return creditPoints;
	}

	public Professor getProfessor() {
		return professor;
	}
	
	//3.setters
	public void setCourseId() {
		courseId = counter;
		counter++;
	}

	public void setTitle(String inputTitle) {
		if((inputTitle != null) && (inputTitle.matches("[A-Z]{1}[A-Za-z0-9 ]{1,40}"))) {
			title = inputTitle;
		}
		else
		{
			title = "Unknown";
		}
	}

	public void setCreditPoints(byte inputCreditPoints) {
		if((inputCreditPoints >= 1) && (inputCreditPoints <= 30)) {
			creditPoints = inputCreditPoints;
		}
		else
		{
			creditPoints = 1;
		}
	}

	public void setProfessor(Professor inputProfessor) {
		if(inputProfessor != null)
		{
			professor = inputProfessor;
		}
		else
		{
			professor = new Professor();
		}
	
	}
	

	
	
	
	//4. bez argumenta konstruktors
	//5. argumenta konstruktors
	//6. toString funkcija
	//7. papildus funkcijas (ja nepieciesams)

}
