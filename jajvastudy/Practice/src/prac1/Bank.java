package prac1;

public class Bank {
	
	//필드
	private String accNo;
	private long balance;
	
	//생성자
	public Bank(String accNo, long balance) {  //Bank b = new Bank("1234", 50000);
		this.accNo = accNo;
		this.balance = balance;
		
	}
	//1. 입급(마이너스 입금 불가)
	public void deposit(long money) {	//b.deposit(50000);
		
		if(money < 0) {
			return;  //반환타입이 void 인 메소드를 종료하는 코드.
		}
		balance += money;
	}
	//2. 출금 (마이너스 출금 + 잔액보다 큰 출금 불가)
	// 실제로 출금된 금액을 반환
	public long withdrawal(long money) {	//long 출금액 = b.withdrawal(50000);
		if (money <= 0 || money > balance) {
			return 0;
		} 
		balance -= money;
		return money;
		
	}
	
	// 3. 이체(출금을 해서 잔액 확인후 이체)
	public void transfer(Bank other, long money) {
		//내 통장에서 출금된 금액만큼 상대 계좌에 입금한다.
		//long withdrawakMoney = withdrawal(money);
		//other.deposit(withdrawakMoney);
		
		//위 두 줄이랑 같은 의미
		other.deposit(withdrawal(money));
	}
	
	// 4.계좌 정보 확인
	public void accInfo() {
		System.out.println("계좌번호 : " + accNo + ", 잔액" + balance + "원");
	}
	
	// 5. main
	public static void main(String[] args) {
		
		Bank me = new Bank("1234", 50000);
		Bank mom = new Bank("4567", 100000);
		
		mom.transfer(me, 50000);
		
		System.out.print("나의 통장 :");me.accInfo();
		System.out.print("엄마의 통장 :"); mom.accInfo();
		
		
		
		
	}
}
