  package prac2;

import java.util.Scanner;

public class SeatGroup {
	
	private String seatType; //"S", "R", "A"
	private Seat[] seats;
	public Scanner sc;
	//인덱스 안넣는 이유  증가시키는것이 아닌 사용자가 선택한 위치로 배열을 넣기위해 
	
	public SeatGroup(String seatType, int cnt) { // S석 ~~개 받아오는 생성자
		this.seatType = seatType;
		seats = new Seat[cnt];
		//^배열에 null값만 넣어두고 의자는 안만든 상태^
		for(int i = 0; i < seats.length; i++) {
			seats[i] = new Seat(); //빈 좌석 가져다두기
		}
		sc = new Scanner(System.in);		
	}
	
	// 예약하는 메소드
	public boolean reserve() {
		reserveInfo();//예약현황 보여주기 (예약현황메소드)
		
		// 시트번호는 1부터 시작
		System.out.print("예약할 시트번호를 입력하시오 >>> ");
		int seatNo = sc.nextInt();
		if (seatNo < 1 || seatNo > seats.length) {
			System.out.println(seatNo + "번 좌석은 없는 좌석입니다.");
			return false;
		}
		//예약된  시트인지 확인
		if (seats[seatNo - 1].isOccupied()) {
			System.out.println(seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false;
		}
		//예약 진행
		System.out.println("예약자 이름 >>> ");
		String name = sc.next();
		sc.nextLine();
		seats[seatNo - 1].reserve(name);// 시트배열에 받은 숫자-1.예약메소드(받은이름)
		System.out.println(seatNo + "번 좌석 예약이 완료되었습니다.");
		return true;
	}
	
	
	//취소하는 메소드
	public boolean cancel() {
		reserveInfo();//예약현황 보여주기 (예약현황메소드)
		System.out.println("취소자 이름 >>> ");
		String name = sc.next();
		sc.nextLine();
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied()) { //예약된 좌석만 비교
				if(seats[i].isMatched(name)) {//예약자 이름과 취소자이름이 같음
					seats[i].cancel();
					System.out.println("예약자" + name + "의 예약이 취소되었습니다.");
					return true;
				}
			}
		}
		System.out.println(name + "의로 예약된 좌석이 없습니다.");
		return false;
		
	}
	
	
	
	//예약 상황 출력
	public void reserveInfo() {
		System.out.println("[" + seatType + "]");
		for(int i =0; i < seats.length; i++) {
			if(seats[i].isOccupied()) {
				System.out.print(seats[i].getName().substring(0,1) + "* ");
			} else {
				System.out.print((i  + 1)+(i < 9 ? "   ":"  "));
			}
			if((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		
	}
	
	
}
