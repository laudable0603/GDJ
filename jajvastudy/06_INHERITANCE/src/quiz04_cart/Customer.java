package quiz04_cart;

public class Customer {
	//필드
	private int money;
	private int bonusPoint;
	private int total;
	private Product[] cart = new Product[10];
	private int idx; //카트에 담긴 Product의 개수. cart배열의 인덱스
	
	
	//생성자 생략
	//new Customer() 가능 
	
	
	//메소드
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	
	
	//buy메소드
	public void buy(Product product) {
		int price = product.getprice();
		//가진돈보다 비싼물건은 못산다.
		if (money <  price) {
			System.out.println(product.getName() + " 사려면 돈이 " + ( price - money) + "원 부족합니다.");
			return;
		}
		//카트가 가득 차면 물건을 못산다.
		if(idx == cart.length) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}
		// 구매
		cart[idx++] = product; //카트에 물건 넣기
		total += price;
		money -= price;
		bonusPoint += price * 0.1;		
		
	}
	
	//receipt() 메소드 영수증 출력
	public void receipt() {
		//물건을 안샀다.
		if(idx == 0) {
			System.out.println("구매한 물건이 없습니다.");
			return;
		}
		//구매 총액 구하기 및 출력
		
		for(int i = 0; i < idx; i++) {
			Product product = cart[i];
			System.out.println(product.getName() + "  " + product.getprice() + "원");
			total += product.getprice();
		}
		System.out.println("______________________________");
		System.out.println("구매총액 " + total + "원");
		System.out.println("보너스" + bonusPoint + "원");
		System.out.println("남은돈 " + money + "원");
	}
	
	
	
	
}
