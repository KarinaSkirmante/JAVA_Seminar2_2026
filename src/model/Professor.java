package model;

import model.enums.ProfDegree;

public class Professor {
	//1. mainigie
	private long profId;
	private String name;
	private String surname;
	private String personCode;
	private ProfDegree degree;
	
	private static long counter = 10000;
	
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
	public void setProfId() {
		profId = counter;
		counter++;
	}
		
	public void setName(String inputName) {
		if((inputName != null) && (!inputName.isEmpty()) && (inputName.matches("[A-Z]{1}[a-z]{2,15}([ ]{1}[A-Z]{1}[a-z]{2,15})?"))    )
		{
			name = inputName;
		}
		else
		{
			name = "Unknown";
		}
	}
	
	
	public void setSurname(String inputSurname) {
		if((inputSurname != null) && (!inputSurname.isEmpty()) 
				&& (inputSurname.matches("[A-Z]{1}[a-z]{2,15}([-]{1}[A-Z]{1}[a-z]{2,15})?"))    )
		{
			surname = inputSurname;
		}
		else
		{
			surname = "Unknown";
		}
	}
	
	public void setPersonCode(String inputPersonCode) {
		//TODO regex masku paskatities, lai ir atbilstosi dienu skaitam konkreta menesi
		if((inputPersonCode != null) && (!inputPersonCode.isEmpty()) 
				&& (inputPersonCode.matches("[0-9]{6}[-]{1}[0-9]{5}")) ) {
			personCode = inputPersonCode;
		}
		else
		{
			personCode = "Unknown";
		}
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
	//4.2. argumenta konstruktors
	//5. toString vunkaijas
	//6. citas funkcijas (ja nepieciesams)

}
