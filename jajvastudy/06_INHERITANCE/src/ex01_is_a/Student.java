package ex01_is_a;

//서브클래스
//extends 키워드를 사용
//             자식   extends  부모
//슈퍼클래스 Person의 모든 메소드를 자기것처럼 사용
//스튜던트 밑에 다른 클래스 생성 후 extends 해주면 후손 만들기 가능.
// 자식 클래스를 호출하면 부모 클래스도 같이 호출된다.

public class Student extends Person{
	
	public void study( ) {
		System.out.println("공부한다.");
	}
}
