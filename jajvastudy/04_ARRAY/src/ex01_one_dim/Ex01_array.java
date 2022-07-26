package ex01_one_dim;

public class Ex01_array {

	public static void main(String[] args) {
		
		
		
		// 배열 (array)
		// 1.여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
		// 2.구성요소
		// 		1)인덱스 : 각 변수의 위치 정보. 0으로 시작
		//		2)배열명 : 모든 변수를 관리하는 하나의 이름
		//3. 각 변수는 배열명에 대괄호[]와 인덱스를 붙여서 구분
		
		//배열 선언 후 생성 > 사용
		// 1. 배열 선언
		//		int[] arr; (배열선언)<java 추천>
		//		int arr []; (동일한 배열 선언)<c언어>
		// 2. 배열 생성 - 해당 배열을 몇개를 사용할 건지 지정함.
		//		arr = new int [3];
		// 3. 배열 선언 및 생성
		//		int[] arr = new int [3]; (한 번에 생성하는 법)
		
		// 배열 요소
		// 1. 배열로 관리되는 각각의 변수
		// 2. 모든 배열 요소의 호출
		//		arr[0(인덱스)]
		// 		arr[1]
		//		arr[2]
		// 3. 배열 요소는 자동으로 초기화 (어떤 값을 가진다.)
		//		값이 없음을 의미하는 0(정수), 0.0(실수), false(boolean), null(String) 값을 가진다.(변수에서는 정수 실수는 0이 안들어감)
		
		// 배열의 장점
		// *변수 3개가 있는 상황				
		// 일반 변수						배열
		// int a, b, c;						int[] arr = new int[3];
		//System.out.println(a);			for (int i = 0; i < 0; i++) {
		//System.out.println(b);					System.out.println(arr[i]);
		//System.out.println(c);			}
		
		int[] arr = new int [26];  //값:배열 length
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr[0] = 100;
		arr[1] = 50;
		arr[2] = 80;
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		int total = 0;
		
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		double average = (double)total / arr.length;
		
		System.out.println("평균 : " + average + "점");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
