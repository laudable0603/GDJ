package ex07_override;

public class CafeLatte extends Espresso{
	
	private int Milk;
	
	@Override
	public void taste( ) {
		System.out.println("달다");
	}
	
}
