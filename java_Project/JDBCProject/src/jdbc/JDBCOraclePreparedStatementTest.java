package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCOraclePreparedStatementTest {

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
			
			// 입력 : insert
			String sqlInsert = "insert into dept values (SEQ_DEPT_DEPTNO.NEXTVAL, 'Design', 'SEOUL')";
			
			int resultCnt = stmt.executeUpdate(sqlInsert);
			
			if(resultCnt > 0) {
				System.out.println("데이터가 정상적으로 입력되었습니다.");
			}
			
			// 4. SQL 실행 : 부서리스트 출력
			String sql = "select * from dept";
			
			
			ResultSet rs = stmt.executeQuery(sql);
			
			// 5. ResultSet 을 이용해서 결과 출력
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString(3);
				
				System.out.println(deptno+"\t"+dname+"\t"+loc);
			}
			
			// 6. close
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
