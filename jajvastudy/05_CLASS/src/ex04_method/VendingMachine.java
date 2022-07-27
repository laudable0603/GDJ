package ex04_method;

public class VendingMachine {
	
	String getCoffee (int money, int button) {
		
		
			String[] menu = {"아메리카노", "카페라떼"};
			return menu[button - 1] + " " + (money / 1000) + "잔";
			
			//String[] menu = {"", "아메리카노" , "카페라떼"};
			//return menu[button] + " " + (money / 1000) + "잔";
		
		
	}
		
		
		
		
		
		
		
		
		
		/*if (bt == 1) {
			
			String result = "아메리카노 " + bt + "잔";
			return result;
		} else if (bt == 2) {
			String result = "카페라떼 " + my/1000 + "잔";
			return result;
		} else {
			String result = "버튼을 잘못눌렀습니다.";
			return result;
		}*/
		
		
	

}
