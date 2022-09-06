package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		// OracleDriver 열기(메모리에 로드하기) 택 1
		// 1. oracle.jdbc.OracleDriver
		// 2. oracle.jdbc.Driver.OracleDriver
		try {
			Class.forName("oracle.jdbc.OracleDriver"); //클래스를 열어주는 클래스 : oralce.jdbc.OracleDriver
		} catch (ClassNotFoundException e) {
			System.out.println("OracleDriver 로드 실패");
		}
		Connection con =  null;
		try {
			
			// DriverManager로부터 Connection 받아오기 java.sql //프로젝트 진행시 String 사용이 아닌 파일로 불러오는게 좋다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";	//DB마다 url은 달라짐(Oracle XE 버전 기준)
			String user = "SCOTT";		// 대소문자 상관없음
			String password = "TIGER"; // 계정 만들 때 사용한 대소문자를 지켜야함
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB접속성공");
		} catch (SQLException e) {
			System.out.println("DB접속정보 오류");
		}
		
		// Connection 종료
		// JDBC에서는 Connection을 닫는 것이 굉장히 중요! 매쿼리마다 열고 작성하고 닫고 하는 잡업이 필요
		try {
			if(con != null) {
			con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		

	}

}
