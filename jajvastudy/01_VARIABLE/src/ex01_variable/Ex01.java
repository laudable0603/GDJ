package ex01_variable;

public class Ex01 {

	public static void main(String[] args) {
		
		// single comment - 한 줄 짜리 주석(설명) 'CTRL + /'대체 가능
		/*
		 * multiple comment 
		 * 여러 줄의 주석
		 */
		
		// 키워드 이름 규칙
		// 1. 패키지 : 모두 소문자. 실제로는 회사 도메인을 거꾸로 작성.(com.samsung.galaxy)
		// 2. 클래스 : 각 단어의 첫 글자만 대문자. 나머지는 소문자.(Upper Camel Case)
		// 3. 변수/메소드 : 첫 글자는 소문자. 이후 단어는 첫글자 대문자 나머지는 소문자 (lower Camel Case)
		// 4. 상수 : 모두 대문자. 밑줄(_)로 연결. (SNAKE_CASE)
		
		// main 메소드
		// 1. 자바 프로젝트를 실행할 때 반드시 필요하다.
		// 2. JVM(JAVA Virtual Machine)은 열려 있는 main 메소드를 실행한다.
		// 3. 열려 있는 main 메소드가 없으면 최근에 실행한 main메소드를 실행한다.
		
		// 변수 선언
		// 사용할 변수의 데이터 타입과 이름을 미리 결정해야 한다.
		// 형식
		// 데이터타입 변수명(식별자) = 초기값;  ex) int sum1 =1;
		
		// 논리 타입 
		boolean isGood = true; // is가 들어가면 논리타입(참/거짓)이라 생각하면 편하다. 꼭 그런건 아님.
		boolean isAlive = false;
		System.out.println(isGood);
		System.out.println(isAlive);
		
		// 문자(character) 타입 : 1개의 글자, 2개 이상의 글자는 안됨
		char ch1 = 'A';
		char ch2 = '홍';
		char ch3 = '\n'; // 라인 피드 - 줄 바꿈
		char ch4 = '\t'; // 탭 > 스페이스 8개의 간격 <
		char ch5 = '\''; //작은 따옴표
		char ch6 = '\"'; //큰 따옴표
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		
		// 정수 타입
		int score = 100;
		//long point = 30000000000; // 롱타입의 데이터타입은 인식했지만 초기값은 int로 인식해서 오류
		long view = 30000000000l;// 롱타입의 숫자를 변수의 적용시킬때 데이터타입도 long을 주고 초기값에도 l,L을 붙여 롱타입이라는 걸 인식 시켜줘야 한다.
		
		System.out.println(score);
		System.out.println(view);
		
		// 실수 타입(소수점)
		
		double discount = 0.5;
		double pi = 3.1415926535;
		System.out.println(discount);
		System.out.println(pi);
		
	}

}
