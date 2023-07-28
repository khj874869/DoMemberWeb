package member.model.dao;
import java.sql.*;

import member.model.vo.Member;

public class MemberDAO {

	public int InsertMember(Connection conn, Member member) {
		String query = "insert into MEMBER_WEB values(?,?,?,?,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT)";
		PreparedStatement pstmt = null;
		int result =0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberAge());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getHobby());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member selectOneById(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mOne = null;
		String query = "select * from MEMBER_WEB where MEMBER_ID= ? AND MEMBER_PW =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset=pstmt.executeQuery();
			if(rset.next()) {
				mOne = rsetTomember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
	}

	public Member selectOneById(Connection conn, String memberId) {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mOne = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,memberId);
			rset=pstmt.executeQuery();
			if(rset.next()) {
				mOne = rsetTomember(rset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mOne;
		
	
	}

	private Member rsetTomember(ResultSet rset) throws SQLException {
		Member mOne = new Member();
		mOne.setMemberId(rset.getString("MEMBER_ID"));
		mOne.setMemberPw(rset.getString("MEMBER_PW"));
		mOne.setMemberName(rset.getString("MEMBER_NAME"));
		mOne.setMemberAge(rset.getInt("MEMBER_AGE"));
		mOne.setGender(rset.getString("MEMBER_GENDER"));
		mOne.setEmail(rset.getString("MEMBER_EMAIL"));
		mOne.setPhone(rset.getString("MEMBER_PHONE"));
		mOne.setAddress(rset.getString("MEMBER_ADDRESS"));
		mOne.setHobby(rset.getString("MEMBER_HOBBY"));		
		mOne.setMemberdate(rset.getTimestamp("MEMBER_DATE"));
		mOne.setUpdatedate(rset.getTimestamp("UPDATE_DATE"));
		mOne.setYN(rset.getString("MEMBER_YN"));
		return mOne;
	}

	public int deletemember(Connection conn,String memberId) {
		String query = "delete from MEMBER_WEB where MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		
		
		return result;
	}

	public int Updatemember(Connection conn, Member member) {
		String query ="UPDATE MEMBER_WEB SET MEMBER_PW = ?,MEMBER_PHONE=?,MEMBER_ADDRESS=?,MEMBER_HOBBY=? WHERE MEMBER_ID = ?, UPDATE_DATE =SYSDATE";
		PreparedStatement pstmt = null;
		int result =0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2,member.getGender());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getHobby());
			pstmt.setString(7, member.getMemberId());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	

}
