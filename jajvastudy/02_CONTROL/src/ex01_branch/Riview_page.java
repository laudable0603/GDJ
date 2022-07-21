package ex01_branch;

public class Riview_page {

	public static void main(String[] args) {
		
		//나이에 따른 결과 출력
		// 0 ~ 7 : 미취학 아동
		// 8 ~ 13 : 초등학생
		// 14 ~ 16 : 중학생
		// 17 ~ 19 : 고등학생
		// 20~   : 성인
		 
		int age = 0;
		
		if (age < 0 || age > 100) {
			System.out.println("잘못된 나이");
		} else if (age <= 7) {
			System.out.println("미취학 아동");
		} else if (age <= 13) {
			System.out.println("초등학생");
		} else if (age <=16) {
			System.out.println("중학생");
		} else {
			System.out.println("성인");
		}
		
		
		
		
		
	}

}
