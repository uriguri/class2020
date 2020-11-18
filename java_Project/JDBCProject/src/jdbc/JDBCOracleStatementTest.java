package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCOracleStatementTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Load ~.~");
			
		
			// 2. DB 연결     localhost == 127.0.0.1
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터베이스에 접속했습니다.");
			
			// 3. Statement 인스턴스 생성
			Statement stmt = conn.createStatement();
			
		
			Scanner sc = new Scanner(System.in);
			
			// 4. SQL 실행 : 부서리스트 출력
			String sql = "select * from dept";
			
			System.out.println("부서이름을 입력해주세요");
			String userDname = sc.nextLine();
			System.out.println("부서의 위치를 입력해주세요.");
			String userLoc = sc.nextLine();
			
			//PreparedStatment 인스턴스 생성
			String sqlInsert = "insert into dept values (seq_dept_deptno.nextval,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1,userDname);
			pstmt.setString(2,userLoc);
			
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt>0) {
				System.out.println("데이터가 정상적으로 입력되었습니다.");
			} else {
				System.out.println("데이터 입력이 되지않았습니다.");
			}
		
			System.out.println("검색하고자 하는 부서의 이름을 입력해주세요.");
			String searchDname = sc.nextLine();
			
			
			// 부서 정보 리스트 
			// String sqlSelect = "select * from dept order by loc";
			String sqlSelect = "select * from dept where dname=? order by loc";
			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setString(1, searchDname);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				System.out.println("검색의 결과가 없습니다.");
			} else {
				 do {
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.print(rs.getString(3)+"\n");					
				} while(rs.next());
			} 
			
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Load Fail T.T");
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		

	}

}
