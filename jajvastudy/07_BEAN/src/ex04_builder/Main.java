package ex04_builder;

public class Main {

	public static void main(String[] args) {
		
		User user = User.builder()
				.userNo(1)
				.id(" admin")
				.email(" admin@naver.com")
				.build();//종료를 의미하는 build 메소드 호출 꼭해야함.
		
		System.out.println(user);

	}

}
