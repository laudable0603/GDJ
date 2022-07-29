package prac1;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		
		//5. 3명의 학생의 점수를 입력 받아서 평균 점수와 1등의 이름과 꼴등의 이름을
		//출력하시오.

		//피카츄의 점수 입력 >>> 75
		//뽀로로의 점수 입력 >>> 95
		//브레드의 점수 입력 >>> 85
		//평균: 85.0점

		//1등: 뽀로로

		//3등: 피카츄
		Scanner sc = new Scanner(System.in);
		String [] student = {"피카츄","뽀로로","브레드"};
		int [] score = new int[student.length];
		for (int i = 0; i < score.length; i++) {
			//스캐너
			System.out.println(student[i] + "의 점수를 입력하세요 >>> ");			
			score[i] =sc.nextInt();
		}				
		
		int total = score[0];
		int max = score[0];
		int min = score[0];
		int top = 0;
		int bottom = 0;						
				
		for(int i = 0; i < score.length; i++) {					
			//1등 꼴찌
			total += score[i];
			if(max < score[i]) {
				max = score[i];
				top = i;
			}
			if(min > score[i]) {
				min = score[i];
				bottom = i;
			}
		}
		double average = (double)total / score.length;
		System.out.println("반 평균 : " + average + "점");
		System.out.println("1등 점수 : " + max + "점, 1등 이름 : " + student[top] );
		System.out.println("꼴등 점수 : " + min + "점, 꼴등 이름 : " + student[bottom]);
		
		
	}

}
