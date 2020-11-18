package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCEx1 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle Driver Load !.!");
			
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("데이터 베이스에 접속했습니다.");
			
			Statement stmt = conn.createStatement();
			
			String sqlEMP = "select * from emp";
			
			ResultSet rs = stmt.executeQuery(sqlEMP);
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");
				
				System.out.println(empno+"\t"+ename+"\t"+job+"\t"+mgr+
									"\t"+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno);
			
			}
				rs.close();
				stmt.close();
				conn.close();
			
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
	

	}

}
