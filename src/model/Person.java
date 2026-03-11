package model;

public class Person {
	//1.mainigie
	private String name;
	private String surname;
	private String personCode;
	//2.getters
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getPersonCode() {
		return personCode;
	}
	//3.setters
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
	
	//4.no args constr
	public Person() {
		setName("Liga");
		setSurname("Jauka");
		setPersonCode("090923-12345");
	}
	//5. args construct
	public Person(String inputName, String inputSurname, String inputPersonCode) {
		setName(inputName);
		setSurname(inputSurname);
		setPersonCode(inputPersonCode);
	}
	
	//6. toString
	public String toString()
	{
		String result = name + " " + surname + " (" + personCode + ")";
		return result;
	}
	
	
}
