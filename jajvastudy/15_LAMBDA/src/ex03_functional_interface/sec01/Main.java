package ex03_functional_interface.sec01;

public class Main {

	public static void main(String[] args) {
		
		MyInterface1 my = () -> System.out.println("울자기 지금 예민하다.");
		my.method();
		MyInterface1 you = () -> System.out.println("울자기 기분이 좋지 않다.");
		you.method();

	}

}
