package ex02_datetime;

import java.util.Calendar;

public class Ex04_Calendar {

	public static void main(String[] args) {
		
		// java.utel.Calendar 클래스
		// 현재 날짜 또는 특정 날짜를 나타낼 때 사용
		// 날짜의 특정요소 ( 년, 월, 일, 시, 분, 초 ...)를 쉽게 사용
		
		
		//클래스(class type) 객체(변수같은느낌) = 
		//8개의 기본타입을 제외하면 전부 클래스로 활용한다.
		
		Calendar cal = Calendar.getInstance(); // 객체 cal은 현재 날짜와 시간으로 구성
		
		//년, 월, 일, 요일
		//                calendar 클래스의 Year 상수값 가져와라 
		int year = cal.get(Calendar.YEAR);//int year = cal.get(1); //연도
		int month = cal.get(Calendar.MONTH) + 1; // 월 //월 : 0 ~ 11 (주의가 필요함)
		int day = cal.get(Calendar.DAY_OF_MONTH); // 일
		int weekNo = cal.get(Calendar.DAY_OF_WEEK); //요일번호 : 일(1),월(2) ... 토(7)
		
		System.out.println(year + "년");				
		System.out.println(month + "월");				
		System.out.println(day + "일");
		switch(weekNo) {
			case 1 : System.out.print("일요일 ");break;
			case 2 : System.out.print("월요일 ");break;
			case 3 : System.out.print("화요일 ");break;
			case 4 : System.out.print("수요일 ");break;
			case 5 : System.out.print("목요일 ");break;
			case 6 : System.out.print("금요일 ");break;
			default : System.out.print("토요일 ");
			
		}
		System.out.println(weekNo);				
		
						
		
		//오전, 오후, 시, 분, 초
		
		int ampm = cal.get(Calendar.AM_PM);//오전(0), 오후(1)
		int hour12 =cal.get(Calendar.HOUR);//시 (1 ~12)
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);//시(0 ~ 23)
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		switch (ampm) {
		case 0 : System.out.println("오전"); break;
		case 1 : System.out.println("오후"); break;
		
		}
		System.out.println(hour12 + "시");
		System.out.println(hour24 + "시");
		System.out.println(minute + "분");
		System.out.println(second + "초");
		
		//time stamp
		
		long timestamp = cal.getTimeInMillis();
		System.out.println(timestamp);
	}

}
