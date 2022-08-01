package ex08_override;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle circle = new Circle("타이어", 7.5);
		circle.info();
		
		Rectangle rectangle = new Rectangle("직사각형", 3, 4);
		rectangle.info();				
		
		Square square = new Square("정사각형", 5);
		square.info();
		
	}

}
