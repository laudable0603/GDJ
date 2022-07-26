package ex04_condition;

public class Ex02 {

	public static void main(String[] args) {
		
		// 논리 연산자
		// 논리 AND : &&, 모두 true이면 true/ 하나라도 false이면 false
		// 논리 OR : ||, 하나라도 true이면 true/ 모두 false이면 false
		// 논리 NOT : !, true는 false / false는 true
		
		int a = 10;
		int b = 10; 
		
		boolean result1 = (a == 10) && (b == 10); // 모두 만족이라 true
		boolean result2 = (a == 10) || (b == 10); // 하나만 만족되어도 true
		boolean result3 = (a == 10) && (b == 20); // 모두 만족이 아니라 false
		boolean result4 = (a == 10) || (b == 20); // 하나가 만족되어도 true
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		
		int c = 10;
		
		boolean result5 = !(c == 10); //결과가 true이니 false
		boolean result6 = !(c == 20); //결과가 false이니 true
		
		System.out.println(result5);
		System.out.println(result6);
		
		// 연습.
		// 변수 n을 10증가시킨 뒤 100보다 크다면 true, 아니면 false
		int n = 95;
		boolean result7 = (n += 10) > 100;
		System.out.println(n);
		System.out.println(result7);
		
		//연습
		//변수 x를 1증가시킨 뒤 x가 10과 같으면 true, 아니면 flase
		int x = 9;
		boolean result8 = (++x) ==10;
		System.out.println(x);
		System.out.println(result8);
		
		// Short Circuit Evaluation
		//논리 AND : false가 발생하면 더 이상 진행하지 않는다. 최종 결과는 false이므로.
		//논리 OR : true가 발생하면 더 이상 진행하지 않는다. 최종 결과는 true이므로.
		int i = 10;
		int j = 10;
		
		boolean result9 = (i == 20) && (++j == 11);
		System.out.println(result9); //false
		System.out.println(j);  	// i == 20 이 false가 발생 했으므로 후 계산을 안해 j는 진행하지 않는다.
		
		boolean result10 = (i == 10) || (++j == 11);
		System.out.println(result10); // true
		System.out.println(j); 		// i == 10이 true가 발생 했으므로 후 계산을 안해 j는 진행하지 않는다.
		// 연산을 해야할 때는 논리연산자 후에 배치하는게 좋다.
	}

}
