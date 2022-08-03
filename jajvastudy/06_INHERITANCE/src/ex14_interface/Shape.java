package ex14_interface;

public interface Shape {
	
	// private String type; //인터페이스에서 사용 불가.
	
	//final 상수
	public final static double PI = 3.141592;
	
	//추상 메소드
	
	//interface에서 abstract는 생략 가능하다. 
	public abstract double getArea();
	
	//default 메소드(본문이 있는 메소드) 1.8버전 이상에서만 가능
	public default void message() {
		System.out.println("나는 도형이다.");
	}
	
	
	
	

}
