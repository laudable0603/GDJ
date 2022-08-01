package quiz04_cart;

public class Product {
	private String name;
	private int price;
	
	
	//이름과 가격을 받는 생성자
	public Product(String name, int price) {		
		this.name = name;
		this.price = price;
	}
	
	//이름과 가격을 외부에서 확인하기 위한 g/s
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	
}
