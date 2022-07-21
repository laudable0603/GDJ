package ex04_condition;

public class Review_page {

	public static void main(String[] args) {
		
		//연습
		// 순위가 1위면 "금메달", 순위가 2위면 "은메달", 순위가 3이면 "동메달"
		//나머지 순위는 "없음"
		
		int rank = 4;
		String medal = (rank == 1)? "금메달" : (rank == 2)? "은메달" : (rank == 3)? "동메달":"없음";
		System.out.println(medal);
		
		//연습.
				//홀수는 "홀수" , 짝수는 "짝수"
				//힌트
				//홀수 -2로 나눈 나머지가 1인 수
				//짝수 -2로 나눈 나머지가 0인 수 
		
		int n = 0;
		
		String type = ((n % 2) == 0)? "짝수":"홀수";
		System.out.println(type);
		
	}

}
