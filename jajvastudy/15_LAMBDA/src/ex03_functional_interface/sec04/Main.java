package ex03_functional_interface.sec04;

public class Main {

	public static void main(String[] args) {
		
		Calculator calc = (a, b) -> a + b;
		String result = calc.add(10, 15) + "";
		System.out.println(result);
		
	}

}
