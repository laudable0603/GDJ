package ex02_casting;

public class Ex03 {

	public static void main(String[] args) {
		
		String strScore = "100";
		String strMoney = "10000000000";
		String strGrade = "4.5";
		
		//문자열을 숫자데이터로 변환하기 (자주있는 일)
		//아래 변환은 매우 중요하다.
		int score = Integer.parseInt(strScore); //문자열 100을 int로 변환
		long money = Long.parseLong(strMoney); // 문자열 1000000000을 long타입으로 변환
		double grade = Double.parseDouble(strGrade);//문자열 4.5를 double타입으로 변환
		
		System.out.println(score);//같은 코드 복붙 할 때 ctrl+ alt 아랫방향키
		System.out.println(money);
		System.out.println(grade);
		
		// 100 -> "100", 4.5 -> "4.5"
		//숫자데이터를 문자열로 변환하기(가끔있는 일)
		int age = 100;
		String strAge = String.valueOf(age);
		System.out.println(strAge);

	}

}
