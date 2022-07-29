package prac1;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {

		//7. 경과시간을 맞추는 게임을 작성하시오. 첫 번째 <Enter>를 누르면 해당 시점의 초
		//시간을 보여주고, 두 번째 <Enter>를 누르면 해당 시점의 초 시간을 다시
		//보여준다. 여기서 10초에 근접하도록 <Enter>를 누른 사람이 이기는 게임이다.

		//<hint>

		//1. <Enter>를 누른다. : Scanner 클래스의 nextLine() 메소드는 <Enter>를 인식함
		//예) <Enter>를 누르면 1000이 출력되는 코드

		//Scanner sc = new Scanner(System.in);
		//sc.nextLine();
		//System.out.println(1000);

		//2. 경과 시간 : System.currentTimeMillis()를 이용해 <Enter>를 누른 시간을 2개
		//구하고, 그 차이를 구한 뒤 0.001을 곱하면 초 단위로 결과를 확인할 수 있다.

		//강아지님 시작하려면 <Enter>를 누르세요.

		//=== 시작 시간(초): 10

		//10초가 된 것 같으면 <Enter>를 누르세요.

		//=== 종료 시간(초): 17

		//고양이님 시작하려면 <Enter>를 누르세요.

		//=== 시작 시간(초): 21

		//10초가 된 것 같으면 <Enter>를 누르세요.

		//=== 종료 시간(초): 29

		//강아지님 결과 7초, 고양이님 결과 8초, 승자는 고양이님입니다.
		
		
		//강아지 시간
		Scanner sc = new Scanner(System.in);
		System.out.print("강아지님 시작하려면 <Enter>키를 누르세요. >>> ");
		String enter1 = sc.nextLine();
		long beginTime = System.currentTimeMillis();
		
		System.out.println("10초가 된것 같으면 <Enter>키를 누르세요. >>> ");
		String enter2 = sc.nextLine();
		long endTime = System.currentTimeMillis();
		
		//강아지 결과
		int dog = (int)((endTime - beginTime) * 0.001);
		
		
		//고양이 시간
		Scanner sc2 = new Scanner(System.in);
		System.out.print("고양이님 시작하려면 <Enter>키를 누르세요. >>> ");
		String enter3 = sc2.nextLine();
		long beginTime2 = System.currentTimeMillis();
		
		System.out.println("10초가 된것 같으면 <Enter>키를 누르세요. >>> ");
		String enter4 = sc2.nextLine();
		long endTime2 = System.currentTimeMillis();
		
		//고양이 결과
		int cat = (int)((endTime2 - beginTime2) * 0.001);
		
		
		
		
		int result1 = dog - cat;
		int result2 = cat - dog;
		if (result1 > result2) {
			System.out.println("강아지님 결과 " + dog + "초 고양이님 결과 " + cat + "초 강아지님 승리");
		} else {
			System.out.println("고양이님 결과" + cat + "초 강아지님 결과 " + dog + "초 고양이님 승리");
		}
		

	}

}
