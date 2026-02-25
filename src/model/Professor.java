package model;

import model.enums.ProfDegree;

public class Professor {
	//1. mainigie
	private long profId;
	private String name;
	private String surname;
	private String personCode;
	private ProfDegree degree;
	
	//2. getters
	public long getProfId() {
		return profId;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getPersonCode() {
		return personCode;
	}
	public ProfDegree getDegree() {
		return degree;
	}
	

	
	//3. setters
	
	
	//4.1. bez ar gumenta konstruktors
	//4.2. argumenta konstruktors
	//5. toString vunkaijas
	//6. citas funkcijas (ja nepieciesams)

}
