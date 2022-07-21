package ex02_loop;

public class Riview_page {

	public static void main(String[] args) {

		//for문
		//연속된 숫자를 생성할 때 주로 사용한다.
		// 배열과 함께 자주 사용된다.
		//실행방식 
		// for (초기문; 조건문; 증감문) { 
		//ex) for( int = 0, i < =10; ++i)
		//		실행문
		//}
		
		for (int n = 1; n < 10; ++n) {
			System.out.println(n);
		}
		
		//연습 구구단 7단 출력
		for (int n = 1; n <= 9; ++n) {
			System.out.println("7x "+ n + "=" + (7 * n));
		}
		
		// 1 ~ 100 사이의 모든 3의 배수만 출력하기
		
		for (int n =1; n <= 100; ++n) {
			if (n % 3 == 0) {
				System.out.println(n + " ");
			}
		}
		
		//1 ~ 100 까지 모든 수 더하기
		
		int sum = 0;
		
		for (int n = 1; n <= 100; ++n) {
			sum += n;
		} 
		System.out.println(sum); //5050
				
		// 평점 (1~5)에 따른 따른 별 (★) 출력하기
		
		int point = 3; 
		
		String star = "";
		for (int n =0; n < point; n++) {
			star += "★";
			
		}
		System.out.println(star);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
	

}
