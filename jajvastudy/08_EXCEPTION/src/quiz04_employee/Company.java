package quiz04_employee;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Company {
	
	private Employee[] employees;
	private int idx;
	private Scanner sc;
	
	public Company() {
		employees = new Employee[5];
		sc = new Scanner(System.in);
	}
	
	public void addEmployee() throws EmployeeException {//full,1 //학생인지 / 직원인지
		if (idx == employees.length) {
			throw new EmployeeException("Full", 1);
		}
		System.out.println("해당 직원의 계약종류를 선택해주세요");
		System.out.print("1.정규직(월급)      2.계약직(시급)  번호 >>> ");
		int choice = sc.nextInt();		
		sc.nextLine();
		if (choice == 1) {
			System.out.print("직원의 이름 입력 >>> ");
			String name = sc.nextLine();
			System.out.print("직원의 사원번호 입력 >>> ");
			int emNum = sc.nextInt();
			sc.nextLine();
			System.out.print("직원의 월급 입력 >>> ");
			int salary = sc.nextInt();
			sc.nextLine();			
			Regular regular = new Regular(emNum, name, salary);
			employees[idx++] = regular;
			
		} else if (choice == 2){
			System.out.print("계약직 이름 입력 >>> ");
			String name = sc.nextLine();
			System.out.print("계약직 사원번호입력 >>> ");
			int emNum = sc.nextInt();
			sc.nextLine();
			System.out.print("계약직 시급 입력 >>> ");
			int pay = sc.nextInt();
			sc.nextLine();
			System.out.print("계약직 일하는시간 입력 >>> ");
			int workTime = sc.nextInt();
			sc.nextLine();
			
			Temporary temporary = new Temporary(emNum, name);
			temporary.setPay(pay);
			temporary.setWorkTimes(workTime);			
			employees[idx++] = temporary;
			
			
		}
		System.out.println("현재 등록된 사원" + idx + "명");
	}
	
	public void dropEmployee() throws EmployeeException {//empty,2//empNo이 일치하면 삭제
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		System.out.println("해고시킬 직원의 사원번호를 입력해주세요 >>>  ");
		int emNum = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < idx; i++) {
			if(emNum == employees[i].getEmpNo()) {
				System.out.println("사원번호 : " + emNum + ", '" + employees[i].getName() + "' 이 해고 되었습니다."); 
				//해당처럼 ~~ 이름을 확인하려면 copy가 진행되기 전에 미리 출력문을 띄워준다.
				System.arraycopy(employees, i + 1, employees, i, idx - i - 1);
				employees[--idx] = null;
				return;
			}
		}
		System.out.println("해당 사원번호를 가진 직운은 존재하지않습니다.");
	}
	
	public void findEmployee() throws EmployeeException {//empty,2
		//아무도 없을때 오류 호출
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		//사원 이름 받아서 비교후 호출
		System.out.println("조회할 사원의 이름 입력 >>> ");
		String name = sc.next();
		
		for (int i = 0; i < idx; i++) {
			if(employees[i].getName().equals(name)) {
				System.out.println(employees[i]);
				return;
			}
		}
		System.out.println("이름 : " + name + "인 직원은 없습니다.");
	}
	
	public void printAllEmployees() throws EmployeeException {//empty,2
		if (idx == 0) {
			throw new EmployeeException("EMPTY", 2);
		}
		for(int i = 0; i < idx; i++) {
			System.out.println(employees[i]);
		}
		
	}
	
	public void manage() {
		
		while(true) {
			try {
				System.out.println("1.직원고용 2.직원해고 3.직원조회 4.전체직원 0.프로그램종료 >>> ");
				int choice = sc.nextInt();
				switch(choice) {
				case 1 : addEmployee(); break;
				case 2 : dropEmployee(); break;
				case 3 : findEmployee(); break;
				case 4 : printAllEmployees(); break;
				case 0 : System.out.println("직원 관리 시스템을 종료합니다.");
				return;
				default : throw new RuntimeException("Bad Request");
				}
			} catch (EmployeeException e){			
				System.out.println(e.getMessage() + "에러코드 : " + e.getErrorCode());
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("숫자로 입력해주세요");				
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
				
			} 
		}
	}
	
}
