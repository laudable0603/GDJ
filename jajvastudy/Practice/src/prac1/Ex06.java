package prac1;

public class Ex06 {

	public static void main(String[] args) {
		
		
		//6. 랜덤으로 윷놀이를 구현하시오. 도개걸윷모 중 랜덤 생성하여 이동 횟수와 함께
		//화면에 출력하시오. 윷이나 모가 나오면 계속 랜덤 생성하여 총 이동 횟수를
		//계산하여 출력하시오.

		//도 : 1칸 이동
		//개 : 2칸 이동
		//걸 : 3칸 이동
		//윷 : 4칸 이동
		//모 : 5칸 이동

		//예시1)

		//개, 2칸 이동한다.
		//예시2)

		//윷, 걸, 7칸 이동한다.
		
		String[] yut = {"", "도","개","걸","윷","모"};	
		int result = 0;

		while(true) {
			
			int move = ((int)(Math.random() *5) + 1);
			
			result += move;
			
			if(move < 4) {
				System.out.println(yut[move] + "," + result + "칸 이동");
				break;
			} else {
				System.out.println(yut[move] + "," + result + "칸이동");
			}
				
			
		}
		 
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
