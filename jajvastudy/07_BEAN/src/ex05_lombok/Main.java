package ex05_lombok;

public class Main {

	public static void main(String[] args) {
		
		
		//get,setter를 이용한 호출
		User user1 = new User();
		user1.setUserNo(1);
		user1.setId("admin");
		user1.setEmail("admin@naver.com");
		
		System.out.println(user1);
		
		//생성자를 이용한 호출
		User user2 = new User(1, "admin", "admin@naver.com");
		System.out.println(user2);
		
		//Builder 클래스를 이용한 호출
		User user3 = User.builder()
				.userNo(1)
				.id("admin")
				.email("admin@naver.com")
				.build();
		
		System.out.println(user3);
		
		
	}

	
}