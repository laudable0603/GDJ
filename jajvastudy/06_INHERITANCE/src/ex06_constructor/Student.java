package ex06_constructor;

public class Student extends Person{
	
	private String School;
	
	

	public Student(String name, String school) {
		super(name);
		School = school;
	}

	public String getSchool() {
		return School;
	}

	public void setSchool(String school) {
		School = school;
	}
	
}
