package ex02_create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateSequenceMain {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			
			//OracleDriver 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//Connection 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";		
			String password = "TIGER";
			con = DriverManager.getConnection(url, user, password);
			
			//쿼리문 작성
			//JDBC에서는 DROP과 CREATE를 한 번에 할 수 없다.
			String sql = "CREATE SEQUENCE BOARD_SEQ NOCACHE";
			ps = con.prepareStatement(sql);
			
			//쿼리문 실행
			ps.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	

	}

}
