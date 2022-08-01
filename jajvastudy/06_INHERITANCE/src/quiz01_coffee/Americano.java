package quiz01_coffee;

public class Americano extends Espresso{
	
	private String type;

	public Americano(String taste, int water, String type) {
		super(taste, water);
		this.type = type;
	}
	@Override
	public void info() {
		// TODO Auto-generated method stub
		super.info();
		System.out.println(type + " 아메리카노");
	}
	
	
}
