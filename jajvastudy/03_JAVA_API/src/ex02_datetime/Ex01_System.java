package ex02_datetime;

public class Ex01_System {

	public static void main(String[] args) {
		
		// 1. 타임스탬프 (item stamp) //중요
		// 1970 -01 -01 0:00부터 1초마다 증가하는 long타입의 정수값
		// 파일의 이름을 타입스탬프로 적용하면 중복값을 막는 용도로 사용할 수 있다.
		long timestamp = System.currentTimeMillis();
		
		System.out.println(timestamp);
		
		
		// 2. 나노타임 (nanoTime)
		// s > ㎳ 밀리(천분의 1초) > ㎲ 마이크로(백만분의 1초) > ㎱ 나노(십억분의 1초) 
		// 나노초 (㎱) 값을 가지는 long 타입의 정수값.
		// 어떤 기준일자는 없어서 두 개의 나노초(㎱) 사이의 경과시간 계산용
		
		
		long beginTime = System.nanoTime();
		int total = 1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println(total+ " 계산에 걸린 시간 : " + (endTime - beginTime) + "㎱");
	}

}
