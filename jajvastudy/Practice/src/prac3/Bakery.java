package prac3;

public class Bakery {

	private int price; //빵가격
	private int cnt;//빵갯
	private int money;//자본금
	
	
	//생성자
	
	public Bakery(int price, int cnt, int money) {
		super();
		this.price = price;
		this.cnt = cnt;
		this.money = money;
	}	
	
	//판매
	public BreadAndChange sell(int custMoney) throws RuntimeException{
		//판매불가
		if(custMoney < price) {
			throw new RuntimeException("돈 더내");
		}
		
		//판매할 수 있는 빵은 몇개인가?
		// 들어온 money를 빵의 가격인 price로 나눈다.
		int sellCnt = custMoney / price;  //빵의 갯수
		
		// 잔돈은 얼마인가?
		int change = custMoney % price; //잔돈
		
		// 매장 내부의 변화 처리
		//매장내에 남은 개수는 판 빵의 개수를 뺀 값
		cnt -= sellCnt;
		
		//매장내 자본금은 (고객이 준 돈 - 잔돈) 처리후 자본금에 넣는다.
		money += (custMoney - change);
		
		//고객에게 되돌려 줄 빵과 잔돈
		return new BreadAndChange(sellCnt, change);
		
		
	}
	
	

	//정보 확인
	public void info() {
		System.out.println("빵 : " + cnt + "개, 자본금 : " + money + "원");
		
		
		
		
		
	}

	

	
	
}
