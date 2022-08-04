package parking;

import java.util.Scanner;

public class ParkingLot {
	
	//필드
	private String name;//주차장이름
	private Car[] cars; //car인스턴스를 저장하는 배열
	private int idx;//배열 인덱스
	private Scanner sc;
	
	//생성자
	public ParkingLot(String name) {		
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);		
	}
	
	//추가 메소드
	private void addCar() {
		System.out.println("현재 등록된 차량 " + idx + "대");
		if(idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}		
		System.out.print("차량번호 입력 >>>  ");
		String carNo = sc.nextLine().replace(" ", "");		
		System.out.print("차량모델명 입력 >>> ");
		String model = sc.nextLine().replace(" ", "");
		
		Car car = new Car(carNo, model);
		cars[idx++] = car;
		
		System.out.println("차량번호 '" + carNo + "' 차량이 등록되었습니다.");
		
	}
	
	//삭제 메소드
	private void deleteCar() {
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.print("삭제할 차량 번호를 입력해주세요 >>> ");
		String carNo = sc.nextLine().replace(" ", "");
		for(int i = 0; i < idx; i++) {
			if(cars[i].getCarNo().equals(carNo)) {
				System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
				cars[--idx] = null;
				System.out.println("차량번호" + carNo.toString() + "차량이 삭제되었습니다.");
				return;
			}
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
		
	}
	
	//전체조회 메소드
	private void printAllCar() {
		if (idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.println(name);
		for(int i = 0; i < idx; i++) {
			System.out.println(cars[i]);
		}
	}
	
	
	//매니저 매소드
	public void manage() {
		
		while(true) {
			System.out.println("1.추가 2.삭제 3.전체 0.종료 >>> ");
			int choice = sc.nextInt();//input오류 해결 
			sc.nextLine();
			
			switch(choice) {
			
			case 1: addCar(); break;
			case 2: deleteCar(); break;
			case 3: printAllCar(); break;
			case 0: System.out.println("주차 프로그램을 종료합니다.");
					return;
			default : System.out.println("존재하지 않는 메뉴입니다.");
			
			}
		}
		
		
	}
	
	
	
	
}
