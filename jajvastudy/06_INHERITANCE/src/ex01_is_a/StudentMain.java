package ex01_is_a;

public class StudentMain {

	public static void main(String[] args) {
		
		Student student = new Student();
		
		//Person클래스에 있지만 student 클래스에 있는것처럼 사용할 수있음.
		student.eat();
		student.sleep();
		student.walk();
		//
		student.study();
		
	}

}
