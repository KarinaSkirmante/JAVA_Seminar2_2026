package model;

//modelu klase
public class Student extends Person{
	//1. mainigie
	private long studId;

	
	//palgmainigais, kam nevajag ne set, ne get
	private static long counter = 0;
	
	//2. get funkcijas
	public long getStudId() {
		return studId;
	}
	
	//3. set funkcijas
	public void setStudId() {
		studId = counter;
		counter++;
	}

	
	//4.1. bezargumenta konstruktors
	public Student() {
		super();//izsauksies automatiski Person() konstruktors
		setStudId();
		
	
	}
	//4.2. argumuneta konstruktors
	public Student(String inputName, String inputSurname, String inputPersonCode) {
		//izsauks Person(String inputName, String inputSurname, String inputPersonCode) konstruktoru
		super(inputName, inputSurname, inputPersonCode);
		setStudId();
	
	}
	//5. toString funkcija
	//@Override //var so nerakstit, bet tapat no bkect kalses toString funkcija tiks parrakstita
	public String toString() {
		// Piemers, 1: Karina Skirmante (121212-12345)
		String result = studId + ": " + name + " " + surname + " (" + personCode + ")";
		return result;
	}
	
	
	//6. visas parejas funkcijas pec nepieciesamibas
}
