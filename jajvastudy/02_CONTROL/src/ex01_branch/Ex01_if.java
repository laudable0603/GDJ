package ex01_branch;

public class Ex01_if {

	public static void main(String[] args) {
		
		// if문(분기문)
		// 조건을 만족하는 경우에만 중괄호 내부 실행, 중괄호는 실행문이 하나일 때 생략 할 수 있으나 생략하지말기
		
		// if(조건) {
		//		실행문
		//  }
		
		int score = 100;
		
		if(score >= 60) {
			System.out.println("합격");
			System.out.println("축하합니다.");
		}
		
		if(score < 60) {
			System.out.println("불합격");
		}
	}

}
