package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import member.Member;

public class MemberDao {

	
	// 데이터 입력
	public int insertMember(Connection conn, Member member) {
		
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sqlInsert = "INSERT INTO memeber (memberid, password, membername) VALUES (?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sqlInsert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultCnt;
	}
}
