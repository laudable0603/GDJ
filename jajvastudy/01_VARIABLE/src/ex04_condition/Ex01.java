package ex04_condition;

public class Ex01 {

	public static void main(String[] args) {
		
		// 비교 연산자
		// 초과 : >
		// 미만 : <
		// 이상 : >=
		// 이하 : <=
		// 같다 : == (하나만 쓰면 대입연산자이기때문에 두개쓴다.)
		// 다르다 : !=
		// 연산 결과는 boolean (true, false)
		// = 등호표시는 먼저 나오는 경우는 없다. 
		
		int a = 7;
		int b = 2;
		
		boolean result1 = a > b; // true
		boolean result2 = a < b; //false 
		boolean result3 = a >= b; //true  
		boolean result4 = a <= b; //false
		boolean result5 = a == b; //false
		boolean result6 = a != b; //true
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		
		
		

	}

}
