package ex03_singleton;

public class Main {

	public static void main(String[] args) {
		
		//singleton 객체는 하나만 생성된다.
		//여러개의 객체가 만들어지면 안되는 경우에 사용
		
		
		User user1 = User.getInstance();
		System.out.println(user1);
		
		User user2 = User.getInstance();
		System.out.println(user2);
		
		//User user3 = new User();  // 외부에서는 새로운 객체를 생성할 수 없음
		
		

	}

}
