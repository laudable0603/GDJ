package quiz04_employee;

public class Regular extends Employee{
	
	private int salary; //월급 

	public Regular(int empNo, String name, int salary) {
		super(empNo, name);
		this.salary = salary;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return super.toString() + ", Regular [salary=" + salary + "]";
	}
	
	
	
}
