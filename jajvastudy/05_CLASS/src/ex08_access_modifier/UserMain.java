package ex08_access_modifier;

public class UserMain {

	public static void main(String[] args) {
		
		User user = new User();
		
		user.setId("admin");
		System.out.println(user.getId());
		
		user.setPw("12345");
		System.out.println(user.getPw());
		
		user.setEmail("laudable0603@gmail.com");
		System.out.println(user.getEmail());
		
		user.setPoint(9999);
		System.out.println(user.getPoint());
		
		
		System.out.println(user.getVip());
		
		
		
		
		
	}

}
