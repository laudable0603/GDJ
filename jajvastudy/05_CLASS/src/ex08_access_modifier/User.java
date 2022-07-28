package ex08_access_modifier;

public class User {
	
	//필드는 private 이다. 
	private String id;
	private String password;
	private String email;
	private int point;
	private boolean isVip;
	
	//메소드는 public이다. (간혹 필요로하면 private를 쓰기도 한다.)
	
	public String getId() {
		
		return id;
	}
	public void setId(String pId) {
		id = pId;
		
	}
	public String getPw() {
		return password;
	}
	public void setPw(String pPw) {
		password = pPw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String pEmail) {
		email = pEmail;
	}
	public int getPoint () {
		return point;
	}
	public void setPoint(int pPoint) {
		point = pPoint;
		setVip(point >= 10000);
	}
	public boolean getVip() {
		return isVip;
	}
	private void setVip(boolean pVip) {
		isVip = pVip;
		
	}
	
	
	
	
	
	
}
