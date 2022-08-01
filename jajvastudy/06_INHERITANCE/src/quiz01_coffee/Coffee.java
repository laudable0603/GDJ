package quiz01_coffee;

public class Coffee {
	
	private String taste;
	private int water;
	
	public Coffee(String taste, int water) {
		
		this.taste = taste;
		this.water = water;
	}
	public void info( ) {
		System.out.println(taste + " 원두, 물 "+ water + "ml");
	}
	
	
	
	

}
