package ex09_this;

public class School {

	//필드 //1차원 선언 후 생성을 해야하는데 생성자의 도움을 받아야한다.
	private Student[] students;
	private int idx; //students 배열의 인덱스. students 배열에 저장된 학생수와 같다.
	
	// 생성자 //생성자의 도움을 받아 cnt에 정수값을 저장한 만큼 배열값이 늘어난다.
	public School(int cnt) {
		students = new Student[cnt];
	}
	
	//메소드 
	public void addStudent(Student student) {
		if(idx == students.length) {
			System.out.println("Full");
			return;
		}
		students[idx++] = student;  // 메소드가 메인에서 불릴 때마다 idx값이 1 높아지면서 출력한다.
	}
	
	public void printStudents() {
		
		/*for (int i = 0; i < idx; i++) {
			System.out.println(students[i].getName() + ", " + students[i].getStuNo());
		}
	}*/
		for(Student student : students) {
			if(student != null) {
			System.out.println(student.getName() + ", "+ student.getStuNo());
		}
	}
		
		
	}
	
	
}
