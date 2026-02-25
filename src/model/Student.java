package model;

//modelu klase
public class Student {
	//1. mainigie
	private long studId;
	private String name;
	private String surname;
	private String personCode;
	
	//palgmainigais, kam nevajag ne set, ne get
	private static long counter = 0;
	
	//2. get funkcijas
	public long getStudId() {
		return studId;
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
	
	//3. set funkcijas
	public void setStudId() {
		studId = counter;
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
	
	//4.1. bezargumenta konstruktors
	//4.2. argumuneta konstruktors
	//5. toString funkcija
	//6. visas parejas funkcijas pec nepieciesamibas
}
