package quiz02_updown;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {
	
	//필드
	private int rand; //1 ~ 100 사이 난수
	private int count; // 시도 횟수 
	private Scanner sc;
	
	//생성자
	public UpDownGame() {
		rand = ((int)(Math.random() * 101));
		sc = new Scanner(System.in);
	}
	
	//입력
	public int input() { // public int input() throws RuntimeException, InputMismatchException{
		
		
			count ++;
			System.out.println("1 ~ 100사이 숫자 입력 >>> ");
			int n = sc.nextInt();
			sc.nextLine();
			if (n < 1 || n > 100) {
				throw new RuntimeException("1~ 100 사이 정수만 입력할 수 있습니다");
			}
			return n;
		
	}
	
	//실행
	public void play() {
	
	//try {
		
		while(true) {
			
			try {
				int n = input();
				if (n < rand) {
					System.out.println("up");
				} else if (n > rand) {
					System.out.println("down");
				} else {
					System.out.println(rand + "정답입니다. " + count + "번만에 정답");
					break;
				}
			} catch (InputMismatchException e) {
				sc.next();//정수가 아닌코드 먹어치우는 용도
				System.out.println("정수만 입력해주세요");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
	//} cath {
		
	//}
		
		
		//맞출때까지 무한루프 while
		
		}
	}
		
	
}
