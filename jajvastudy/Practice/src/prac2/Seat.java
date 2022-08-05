package prac2;

public class Seat {
	
	private String name; //시트 예약한 사람이름
	
	//빈자리로 시작할것이기에 생성자는 만들지 않아 
	// 디폴트 생성자로 시작한다.
	
	
	//예약한 사람 이름
	public String getName() {
		return name;
	}	
	//예약
	public void reserve(String name) {
		this.name = name;
	}
	
	//예약 취소
	public void  cancel() {
		name = null;
	}
	
	//예약 여부 확인
	public boolean isOccupied() {
		return name != null;		//null이 아니면 true 반환- 예약되어있으며 true 반환이란 뜻
									
	}
	
	//예약자 확인
	public boolean isMatched(String name) {
		return this.name.equals(name); //받아온 이름과 저장된 이름 비교법 같으면 true반환
	}
	
	
	
	
	
	
	
}
