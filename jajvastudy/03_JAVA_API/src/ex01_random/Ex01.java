package ex01_random;

public class Ex01 {  //클래스

	public static void main(String[] args) { //메소드
		// 난수 (Random number) 발생
		// Random 클래스, math 클래스 주로 활용한다.
		
		System.out.println(Math.random());
		
		// 0.0 <= Math.random() < 1.0
		// 0% <= Math.random() < 100%
		
		//1. 확률 처리하기
		//10%확률로 "대박", 90%확률로 "쪽박"
		
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
		
		
		
		// 2. 값 생성
		
		//math.random()            0.0 <= n < 1.0
		//math.random()            0.0 <= n < 5.0
		//(int)(math.random() *5)     0 <= n <  5
		//(int)(math.random() *5)+1   1 <= n <  6
		
		for(int n = 0; n < 2; n++) {
			int dice = (int)(Math.random() *6) + 1;
			System.out.println("주사위" + dice);
		}
		String code = "";
		for(int n = 0; n < 6; n++) {
			code += (int)(Math.random()*10);
		}
		System.out.println(code);
		
		//65~90사이가 발생됨
		// 'A' == 65  같은 의미이기에 
		// 'A' + 1 > 이런식의 식도 처리 가능하다.
		
		
		System.out.println((char)((int)(Math.random() * 26) + 65)); // < 같은의미
		System.out.println((char)((int)(Math.random() * 26) + 'A')); // < 같은의미
		
		
		//연습
		//6자리 영문(대문자+소문자) 인증번호 만들기
		String aski = "";
		for(int n = 0; n < 6; n++) {
			if(Math.random() < 0.25) {
				aski +=((char)((int)(Math.random() * 26) + 'a'));
			} else {
				aski +=((char)((int)(Math.random() * 26) + 'A'));
			}
			
		}
		System.out.println(aski);
		
		
		
		
	}
	

}
