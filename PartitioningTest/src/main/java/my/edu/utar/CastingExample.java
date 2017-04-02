package my.edu.utar;

class Human {
	
	int myKad = 1;
	
	public void identify() {
		System.out.println ("I am a human");
	}
	
}

class Doctor extends Human {
	
	int myKad = 5;
	int doctorID = 500;
	
	public void identify() {
		System.out.println ("I am a doctor");
	}
	
}

class Surgeon extends Doctor {
	
	int myKad = 10;
	int surgeonID = 1000;
	
	public void identify() {
		System.out.println ("I am a surgeon");
	}
}

public class CastingExample {

	public static void main(String[] args) {
		
		Human h1 = new Human();
		Doctor d1 = new Doctor();
		Surgeon s1 = new Surgeon();
		
		Human h2 = new Doctor();
		h2.identify();
		System.out.println (h2.myKad);
//		System.out.println (h2.doctorID);
		
		Human h3 = new Surgeon();
		h3.identify();
		System.out.println (h3.myKad);
//		System.out.println (h3.surgeonID);
		
//		d1 = new Human();
//		s1 = new Human();
		
		System.out.println ("Doctor ID  and myKad : ");
		Doctor d2 = (Doctor) h2;
		System.out.println (d2.doctorID);
		System.out.println (((Doctor) h2).doctorID);
		System.out.println (d2.myKad);

		System.out.println ("Surgeon ID and myKad : ");
		Surgeon s2 = (Surgeon) h3;
		System.out.println (s2.surgeonID);
		System.out.println (((Surgeon) h3).surgeonID);
		System.out.println (s2.myKad);
		
		Human h4 = new Human();
		d2 = (Doctor) h4;
		s2 = (Surgeon) h4;
		
		System.out.println ("Calling showMyKadID with a human");
		showMyKadID(new Human());
		System.out.println ("Calling showMyKadID with a doctor");
		showMyKadID(new Doctor());
		System.out.println ("Calling showMyKadID with a surgeon");
		showMyKadID(new Surgeon());

	}
	
	public static void showMyKadID(Human h) {
		h.identify();
		if (h instanceof Surgeon) {
			Surgeon s = (Surgeon) h;
			System.out.println ("Surgeon ID : " + s.surgeonID);
			System.out.println ("Surgeon myKad : " + s.myKad);
		}
		else if (h instanceof Doctor) {
			Doctor d = (Doctor) h;
			System.out.println ("Doctor ID : " + d.doctorID);
			System.out.println ("Doctor myKad : " + d.myKad);
		}
		else {
			System.out.println ("Human myKad : " + h.myKad);
		}
	}
	
	// This method explicitly expects that its parameter
	// is either from the Doctor or Surgeon class type
	// otherwise an Exception is thrown
	
	public static void anotherMethod(Human h) {
		if (!(h instanceof Doctor))
			throw new IllegalArgumentException();
		
		// rest of code
	}
}
