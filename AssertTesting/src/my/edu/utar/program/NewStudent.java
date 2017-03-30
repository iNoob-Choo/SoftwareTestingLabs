package my.edu.utar.program;

public class NewStudent {
	private String name;
	private int age;

	public NewStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean equals(Object obj) {
		if (obj instanceof NewStudent) {
			NewStudent compareStudent = (NewStudent) obj;
			if (name.equals(compareStudent.getName()) && age == compareStudent.getAge())
				return true;
		}
		return false;
	}

	public static void main(String[] args) { 
 
		NewStudent stu1 = new NewStudent("Ah Beng", 25);
		NewStudent stu2 = stu1;
		NewStudent stu3 = new NewStudent("Ah Beng", 25);
		if (stu1 == stu2)
			System.out.println("stu1 & stu2 are referring to the same object");
		else
			System.out.println("stu1 & stu2 are NOT referring to the same object");
		if (stu1 == stu3)
			System.out.println("stu1 & stu3 are referring to the same object");
		else
			System.out.println("stu1 & stu3 are NOT referring to the same object");

		if (stu1.equals(stu2))

			System.out.println("Student objects referred to by stu1 & stu2 have identical instance variable values");
		else
			System.out.println(
					"Student objects referred to by stu1 & stu2 DO NOT have identical instance variable values");
		if (stu1.equals(stu3))
			System.out.println("Student objects referred to by stu1 & stu3 have identical instance variable values");
		else
			System.out.println(
					"Student objects referred to by stu1 & stu3 DO NOT have identical instance variable values");
	}
}