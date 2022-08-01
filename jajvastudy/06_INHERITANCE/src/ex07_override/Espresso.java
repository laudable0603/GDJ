package ex07_override;


public class Espresso extends Coffee{
	
	@Override    //override 적어주는 이유 같은 값을 쓰지만 다른 의미로 사용할 때 사용
	//메소드에 오타가 있는지 확인도해준다.
	public void taste( ) {
		System.out.println("쓰다.");
		
	}
	
	
	
	
}
