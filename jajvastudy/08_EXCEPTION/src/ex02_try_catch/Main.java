package ex02_try_catch;

import java.io.File;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void m1() {
		
		try {			
			String[] hobbies = new String[3];			
			hobbies[1] = "swimming";
			hobbies[2] = "running";			
			for(String hobby : hobbies) {
				System.out.println(hobby.substring(0,2));//null값이 있는데 메소드를 호출하면 오류 발생
			}
			
		} catch(Exception e) {
			System.out.println("Exception 발생");
		}
	}
	
	
	public static void m2() {
		try {
		String input = "20, 21, 22, 23, 24, 25";		
		String[] inputs = input.split(",");
		int[] ages = new int[input.length()];	
				
		for (int i = 0; i <inputs.length ; i++) {
			ages[i] = Integer.parseInt(inputs[i]);
			System.out.println("변환 값 : " + ages[i]);
		}
	} catch(NumberFormatException e) {
		System.out.println("NumberFormatException 발생");
	} catch(Exception e) {
		System.out.println("Exception 발생");
	} 
		
		
		// int[] ages = {20, 21, 22, 23, 24, 25};
	}
	public static void m3() {
		//어떤 예외가 발생하는지 확인해서
		//try - Catch문 넣기(Exception,RuntimeException은 사용하지 않기)
	try {		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 1 >>> ");
		int a = sc.nextInt();		
		System.out.println("정수 2 >>> ");
		int b = sc.nextInt();		
		System.out.println(a + "+" + b + "=" + (a + b));		
		System.out.println(a + "-" + b + "=" + (a - b));		
		System.out.println(a + "*" + b + "=" + (a * b));		
		System.out.println(a + "/" + b + "=" + (a / b));		
		System.out.println(a + "%" + b + "=" + (a % b));
		sc.close();
	} catch (InputMismatchException e){
		System.out.println("InputMismatchException 발견");
	} catch(ArithmeticException e)  {
		System.out.println("ArithmeticException 발견");
	}
		
	}
	public static void m4() {
		
		try {
		//try-catch문이 없으면 실행이 불가능한 Checked Exception
		File file = new File("C:\\samle.txt"); //특정 파일 읽어서 file에 넣기
		FileReader fr = new FileReader(file); // 불러온 파일  읽어보기 
		}catch (Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		
		m4();

	}

}
