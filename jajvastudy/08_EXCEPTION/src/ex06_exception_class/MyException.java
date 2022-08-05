package ex06_exception_class;



//사용자 정의 예외 클래스
// Exception 클래스를 상속 받는다.

// Serializable 인터페이스 : 이 인터페이스를 구현하면 직렬화가 가능. erialVersionUID값을 가져야함 (추천)
//  ↑
// Throwable 클래스 : serialVersionUID값이 필요함
//	↑
// Exception 클래스 : serialVersionUID값이 필요함
//	↑
//MyException 클래스 : serialVersionUID값이 필요함
public class MyException  extends Exception{
	
	private static final long serialVersionUID = -7774118171104436322L;
	
	private int errorCode;

	public MyException(String message, int errorCode) { //String message는 Exception 클래스가 가지고있기에
		super(message);									// 해당처럼 생성자 작성을 해줘야한다.
		this.errorCode = errorCode;						// 에러코드만 작성해주면된다.
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
