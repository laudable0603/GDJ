package ex03_number;

public class Review_page {

	public static void main(String[] args) {
		
		//연습
		//25을 2와 5로 나눠보기
		
		int n = 25;
		int ten = n / 10; // 몫을 구할 때 쓰는 산술연산
		int one = n % 10; // 나머지를 구할 때 쓰는 산술연산
		
		System.out.println(ten);
		System.out.println(one);
		// 연습
		// 90초를 1분 30초로 나눠보기
		
		int second = 90;
		int m = second / 60 ;
		int s = second % 60;
		
		System.out.println(m);
		System.out.println(s);
		
		
		//연습
		// a = 7이고, b = 2이므로
		// a 나누기 b는 3.5이다.
		// 결과값이 소수점인 경우 강제형변환을 해준다.
		
		int a = 7, b = 2; 
		double result1 = (double) a / b;
		System.out.println(result1);
	}

}
