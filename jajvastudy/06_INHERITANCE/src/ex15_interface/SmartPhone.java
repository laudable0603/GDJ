package ex15_interface;

public class SmartPhone extends Phone implements Computer{

	@Override
	public void call() {
		System.out.println("전화기능");
		
	}
	@Override
	public void sms() {
		System.out.println("문자기능");
		
	}
	@Override
	public void game() {
		System.out.println("게임기능");
		
	}

	@Override
	public void internet() {
		System.out.println("인터넷기능");
		
	}


	
	
	
	
	

}
