package quiz04_employee;

public class Employee {
	
	private int empNo; //직원 사번
	private String name; //직원 이름
	
	public Employee(int empNo, String name) {
		super();
		this.empNo = empNo;
		this.name = name;
	}

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name ;
	}
	
	
	
	
}
