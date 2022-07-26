package ex01_one_dim;

import java.util.Arrays;

public class Ex03_array {

	public static void main(String[] args) {
		
		
		
		// 배열의 데이터타입
		// int [] : 참조 타입(Reference Type)
		
		/*
		 
		 int [] arr = { 10000, 20000, 30000};
		 
				|-------|
 	 	arr		| 0x123 |
		 		|-------|
		 		| ....  |
		 		|-------|
	arr[0]		| 10000 |  0x 123
		 		|-------|
	arr[1]	 	| 20000 |
		 		|-------|
	arr[2]	 	| 30000 |
		 		|-------|
		 		 	   
		 */
		
		// 배열의 길이 늘리기
		// 1. 배열의 길이는 변경할 수 없다.
		// 2. 늘어난 길이의 새로운 배열을 만들고, 
		//		기존 배열의 값을 모두 새로운 배열로 옮기고,
		//		기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		
		// 배열의 길이를 늘리면 메모리 누수 공간이 발생하는데 
		//java는 스스로 해결한다. 단 속도 느림 c언어 같은 곳 가서 실행하면 오류발생
		//java에서 누수공간처리 독촉을 할 수 있다 단, 처리는 아님
		// System.gc();
		
		
		// 길이가 5인 배열을 사용하다가 
		// 길이가 1000인 배열로 바꾸기
		
		int[] arr = {1, 2, 3, 4, 5};
		
		//늘어난 길이의 새로운 배열을 만들고, 
		int[] temp = new int[1000];
		
		//기존 배열의 값을 모두 새로운 배열로 옮기고,
		System.arraycopy(arr, 0, temp, 0, arr.length);
		
		//기존 배열의 참조값을 새로운 배열의 참조값으로 수정한다.
		arr = temp;
		
		// 이제 arr 배열의 길이는 1000이다.
		System.out.println(arr.length);
		System.out.println(Arrays.toString(arr)); //Arrays.toString(); 배열의 요소를 보여준다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
