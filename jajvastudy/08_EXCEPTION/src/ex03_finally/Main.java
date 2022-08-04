package ex03_finally;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// finally 블록
		// 1. try- catch 문 마지막에 추가하는 블록
		// 2. 예외발생과 상관없이 언제나 마지막에 실행되는 블록
		Scanner sc = new Scanner(System.in); 
		try {
			//Scanner sc = new Scanner(System.in); //메소드내에서 사용하기위해 바깥쪽에서 다시ㄴ생성
			System.out.println("나이 입력 >>> ");
			String strAge = sc.nextLine();
			int age = Integer.parseInt(strAge);
			System.out.println(age >= 20 ? "성인" : "미성년자");
			//sc.close(); //자원손실
		} catch (Exception e) {
			System.out.println("예외 발생");
		} finally {
			sc.close();
			System.out.println("finally 블록 실행");
		}

	}

}
