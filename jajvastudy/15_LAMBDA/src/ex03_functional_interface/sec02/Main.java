package ex03_functional_interface.sec02;

public class Main {

	public static void main(String[] args) {
		
		MyInterface2 my = (a, b) -> System.out.println(a + b);
		my.method(1,5);
	}

}
