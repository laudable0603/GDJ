package prac1;

public class Gun {
	
	//필드 
	private String model;
	private int bullet;
	
	public static final int MAX_BULLET = 15;
	
	//생성자	
	public Gun (String model, int bullet) {
		this.model = model;
		this.bullet = bullet;
	}
	
	//info
	public void info (String model) {
		System.out.println(this.model);
	}
	
	
	
	
	//장전
	public void reload(int bullet) {
		if (this.bullet == MAX_BULLET) {
			System.out.println("0발이 장전되었다. 현재: " + this.bullet);
			return;
		}
		this.bullet += bullet;
		this.bullet = (this.bullet > MAX_BULLET) ? MAX_BULLET : this.bullet;
		System.out.println(bullet + "이 장전되었다. 현재 : " + this.bullet);
	}
	//총쏘기
	public void shoot() {
		if(bullet == 0) {
			System.out.println("헛빵!");
			return;
		}
		bullet--;
		System.out.println("빵야!" + this.bullet + "남았다.");
	}

	
	

}
