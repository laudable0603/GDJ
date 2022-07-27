package ex01_field;

public class UserMain {
	//int a;//필드
	public static void main(String[] args) {
		
		//int b;//변수
		
		//클래스(데이터타입) : User 
		//객체(변수 개념, 인스턴스)  : user 
		
		//int a = 10;//변수//변수는 변수가 가진게 끝
		//String s = "hi";
		//객체//객체는 객체의 기능을 꺼낼 수 있다.
		//동일 패키지에서는 import가 되지 않는다.
		
		//객체 선언
		//User user = null;
		
		//객체 생성
		//user = new User();
		
		// 객체 선언과 생성을 한 번에
		User user = new User();
		
		//모든 User 객체는 필드값을 가지고 있다.
		// 마침표(.)를 이용해서 필드값을 호출한다.
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.pount);
		System.out.println(user.isVip);
		
		// 필드값 변경
		user.id = "admin";
		user.password = "123456";
		user.email = "admin@web.com";
		user.pount = 1000;
		user.isVip = (user.pount >= 10000);
		
		System.out.println(user.id);
		System.out.println(user.password);
		System.out.println(user.email);
		System.out.println(user.pount);
		System.out.println(user.isVip);
		
		
		
		
		
		
		
		
		
		
		
	}

}
