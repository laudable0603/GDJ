package prac1;


import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		//1. 점수와 학년을 입력받아 60점 이상이면 합격, 60점 미만이면 불합격을 출력하시오.
		//4학년인 경우 70점 이상이어야 합격이다.

		//점수를 입력하세요(0~100) >>> 65
		//학년을 입력하세요(1~4) >>> 1
		//합격!

		//점수를 입력하세요(0~100) >>> 65
		//학년을 입력하세요(1~4) >>> 4
		//불합격!
		Scanner sc = new Scanner(System.in);
		System.out.print("학년을 입력하세요 >>> ");
		int grade =sc.nextInt();
		
		
		System.out.print("점수를 입력하세요 >>> ");
		int score =sc.nextInt();
		
		if (grade < 4) {
			System.out.println(score >= 60 ? "합격" : "불합격");
		} else {
			System.out.println(score >= 70 ? "합격" : "불합격");
		}
		
	
		
		
		
		
		
		//2. 커피 메뉴를 입력받아 가격을 알려주는 프로그램을 구현하시오. switch 문을 이용
		//하여 구현하시오.

		//(에스프레소, 카푸치노, 카페라떼는 3500원, 아메리카노는 2000원이다.)

		//무슨 커피 드릴까요? >>> 에스프레소
		//에스프레소는 3500원입니다.

		//무슨 커피 드릴까요? >>> 아메리카노
		//아메리카노는 2000원입니다.

		//무슨 커피 드릴까요? >>> 밀크커피
		//밀크커피는 메뉴에 없습니다.
		
		Scanner sc2 = new Scanner(System.in);
		System.out.print("무슨 커피를 드릴까요 >>> ");
		String coffee = sc2.nextLine();
		
		
		
		switch (coffee) {
		case "에스프레소" :
		case "카푸치노" :
		case "카페라떼" : System.out.println(coffee + "는 3500원입니다."); break;
		case "아이스아메리카노" : System.out.println(coffee + "는 2000원입니다.");
		default : System.out.println(coffee + " 는 메뉴에 없습니다.");
		}
		
		
		//3. 돈을 입력받아 오만원권, 만원권, 오천원권, 천원권, 오백원 동전, 백원 동전, 오
		//십원 동전, 십원 동전, 오원 동전, 일원 동전이 각각 몇 개로 변환되는지 출력하시
		//오. 이 때 반드시 다음과 같은 배열을 사용하여 반복문으로 처리하시오.

		//int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

		//금액을 입력하시오 >> 75832
		//50000원 짜리 : 1개

		//10000원 짜리 : 2개

		//5000원 짜리 : 1개

		//500원 짜리 : 1개

		//100원 짜리 : 3개

		//10원 짜리 : 3개

		//1원 짜리 : 2개
		Scanner sc3 = new Scanner(System.in);
		System.out.print("금액을 입력하세요 >>> ");
		int money =sc3.nextInt();
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		//(int)(money/50000);//오만원권
		//(int)(money/10000);//만원권
        //(money%10000)/5000;//오천원권
        //(money%5000)/1000;//천원권
        //(money%1000)/500;//오백원권
        //(money%500)/100;//백원권
        //(money%100)/50;//오십원
		//(money%50)/10;//십원
		//(money%10)/1;//일원
		for(int i = 0; i<unit.length; i++) {
            System.out.println(unit[i] + "원 : " + (money/unit[i]) + "개");
            money %= unit[i]; // money를 unit[i]로 나누고 그 나머지를 money에 대입한다. 
        }
    
		

		//4. 정수를 몇 개 저장할지(최대 100개) 입력받아서 해당 길이를 가진 배열을 생성하
		//고, 이곳에 1에서 100사이 범위의 정수를 랜덤하게 삽입하시오. 같은 값은 생성하
		//지 못하도록 설정하고 생성된 배열을 출력하시오.

		//몇 개의 랜덤을 생성할까요? >>> 150
		//다음에는 1~100사이로 입력하세요!

		//몇 개의 랜덤을 생성할까요? >>> 25

		//29     64     47     14     37     61     83     33     65     96

		//48     44     92     77     70     34     23     35     13     68

		//74     15     67     42     38
		
	}

	
}
