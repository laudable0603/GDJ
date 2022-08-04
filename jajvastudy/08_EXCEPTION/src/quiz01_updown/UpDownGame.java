package quiz01_updown;

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
	public int input() {
		
		try {
			count ++;
			System.out.println("1 ~ 100사이 숫자 입력 >>> ");
			int n = sc.nextInt();
			sc.nextLine();
			if (n < 1 || n > 100) {
				throw new RuntimeException("1~ 100 사이 정수만 입력할 수 있습니다");
			}
			return n;
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력할 수 있습니다.");
			sc.next();  //잘못 입력된 문자열 먹어 치우기
			input();  //재귀호출 자기자신을 다시 호출해 다시 실행한다.
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			input();
		}
		return 0;  //이클립스 안심시키는 용도
	}
	
	//실행
	public void play() {
	
	//try {
		
		while(true) {
			int n = input();
			if (n < rand) {
				System.out.println("up");
			} else if (n > rand) {
				System.out.println("down");
			} else {
				System.out.println(rand + "정답입니다. " + count + "번만에 정답");
				break;
			}
	//} cath {
		
	//}
		
		
		//맞출때까지 무한루프 while
		
		}
	}
		
	
}
