package quiz02_coffee;

public class Americano {
	
	private Espresso espresso;
	private int shot;
	private String type;
	
	public Americano(Espresso espresso, int shot, String type) {
		super();
		this.espresso = espresso;
		this.shot = shot;
		this.type = type;
	}
	
	public Americano(String string, int shot2, String type2) {
		// TODO Auto-generated constructor stub
	}

	public void info () {
		espresso.info();
		System.out.println(shot + "샷");
		System.out.println(type + "아메리카노");
	}
	
	
	
	
	
}
