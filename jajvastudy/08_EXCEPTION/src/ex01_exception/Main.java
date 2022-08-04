package ex01_exception;

import java.util.Scanner;

public class Main {
	
	public static void m1() {
		
		//NullpointerException: null값이 어떤 메소드를 호출 할 때 발생
		String[] hobbies = new String[5];
		
		hobbies[1] = "수영";
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";
		
		for(int i = 0; i < hobbies.length; i++){
			if(hobbies[i].equals("수영")) {  //hobbies[0].equals를 불러오는데 0번 배열이 null이면 NullpointerException
				System.out.println("취미가 나와 같군요");
			}
		}
				
		
	}
	public static void m2() {
		
		//NullpointerException회피
		String[] hobbies = new String[5];
		
		hobbies[1] = "수영";
		hobbies[2] = "골프";
		hobbies[3] = "영화";
		hobbies[4] = "집콕";
		
		for(int i = 0; i < hobbies.length; i++){
			if(hobbies[i] != null&&hobbies[i].equals("수영")) {  
				System.out.println("취미가 나와 같군요");
			}
		}
				
		
	}
	public static void m3() {
		
		//NumberFormatException : String을 Number타입으로 변경할 때 발생
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine();
		System.out.println("나이 입력(선택) >>> ");
		String strAge = sc.nextLine(); //입력 없이 Enter만 누르면 strAge는 빈 문자열을 가짐
		int age = Integer.parseInt(strAge); // strAge값을 인트값으로
		
		System.out.println("이름 : " + name + ", 나이 : " + age + "살");
		
	}
	
	public static void m4() {
		
		//NumberFormatException의 회피
		Scanner sc = new Scanner(System.in);
		System.out.println("이름 입력(필수) >>> ");
		String name = sc.nextLine();
		System.out.println("나이 입력(선택) >>> ");
		String strAge = sc.nextLine(); //입력 없이 Enter만 누르면 strAge는 빈 문자열을 가짐
		int age;
		if(strAge.isEmpty()) { //strAge가 문자열의 길이가 0인 경우에, true를 리턴ㄴ
			age = 0;
 		}else {
 			age = Integer.parseInt(strAge); // strAge값을 인트값으로
 		}
		
		 
		
		System.out.println("이름 : " + name + ", 나이 : " + age + "살");
		
	}
	//static은 static만 부를 수 있다.
	public static void main(String[] args) {
		m4();
		

	}

}
