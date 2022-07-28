package ex10_this;

public class Rectangle {
	
	//필드
	private int width;
	private int height;	
	
	//생성자
	public Rectangle (int width, int height) {
		this.width = width;
		this.height = height;
	}
	public Rectangle (int n) {
		this(n, n);// 옆코드와 같은 뜻 this.width = n;, this.height = n; 
		//인수 2개인 다른 생성자를 호출한다.
	}
	
	
	//메소드
	public int getArea() {
		return height * width;
	}
	
	public int getCircumference() {
		return (height + width) * 2;
	}
	
	
}
