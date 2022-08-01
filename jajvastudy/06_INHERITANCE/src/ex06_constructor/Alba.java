package ex06_constructor;

public class Alba  extends Student{
	
	

	private String Company;
	
	
	public Alba(String name, String school, String company) {
		super(name, school);
		Company = company;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}
	
	
	
	
}
