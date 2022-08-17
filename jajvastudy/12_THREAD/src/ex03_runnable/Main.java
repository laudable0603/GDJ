package ex03_runnable;

public class Main {

	public static void main(String[] args) {
		
		// Runnable 인터페이스를 구현한 클래스는 Thread로 바꿔야 start()메소드를 호출할 수 있다.
		
		
		//생성방법은 아래중 택
		Runnable robot1 = new WashRobot("로봇1");
		Thread thread1 = new Thread(robot1);
		
		//또는
		WashRobot robot2 = new WashRobot("로봇2");
		Thread thread2 = new Thread(robot2);
		
		
		//또는 (추천_)
		Thread thread3 = new Thread(new WashRobot("로봇3"));
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
		
	}

}
