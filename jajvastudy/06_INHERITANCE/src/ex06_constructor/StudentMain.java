package ex06_constructor;

public class StudentMain {

	public static void main(String[] args) {
		
		Student student = new Student("tom", "goodee");
		
		System.out.println(student.getName()); //Person에 있는 매개지만 부모클래스이기에 사용가능 
		System.out.println(student.getSchool());
		
		Alba alba = new Alba("jessica", "seoul univ", "library");
		
		System.out.println(alba.getName());
		System.out.println(alba.getSchool());
		System.out.println(alba.getCompany());

	}

}
