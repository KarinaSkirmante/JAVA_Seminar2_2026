package model;

import model.enums.ProfDegree;

public class Professor extends Person {
	//1. mainigie
	private long profId;

	private ProfDegree degree;
	
	private static long counter = 10000;
	
	//2. getters
	public long getProfId() {
		return profId;
	}
	
	public ProfDegree getDegree() {
		return degree;
	}
	
	
	//3. setters
	public void setProfId() {
		profId = counter;
		counter++;
	}
		
	
	
	public void setDegree(ProfDegree inputDegree) {
		if(inputDegree!=null) {
			degree = inputDegree;
		}
		else
		{
			degree = ProfDegree.unknown;
		}
	}

	
	
	//4.1. bez ar gumenta konstruktors
	public Professor() {
		super("Karina","Skirmante","121212-56794"); //tiek izsaukts: Person(String inputName, String inputSurname, String inputPersonCode)
		setProfId();
		setDegree(ProfDegree.master);
	}
	//4.2. argumenta konstruktors
	public Professor(String inputName, String inputSurname, String inputPersonCode, 
			ProfDegree inputDegree) {
		super(inputName, inputSurname, inputPersonCode);
		setProfId();
		setDegree(inputDegree);
	}
	//5. toString funkcija
	public String toString() {

		String result = profId + ": " + name + " " + surname + " (" + personCode + ") " +
		degree;
		return result;
	}
	//6. citas funkcijas (ja nepieciesams)

}
