package member.model.service;

import java.sql.*;

import common.JDBCTemplate;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	private JDBCTemplate jdbctemplate;
	private MemberDAO mDao;

	public MemberService() {
		jdbctemplate=JDBCTemplate.getInstance();
		 mDao= new MemberDAO();
	}
	public int InsertMember(Member member) {
		
		Connection conn = jdbctemplate.createConnection();
		MemberDAO mdao= new MemberDAO();
		int result = mdao.InsertMember(conn,member);
		//커밋 롤백
		if(result>0) {
			//성공 커밋
			jdbctemplate.commit(conn);
		}else {
			//실패 - 롤백
			jdbctemplate.rollback(conn);
		}		
		return result;
	}
	//연결 생성
	//DAO 호출
	//커밋 / 롤백 

	public int updateMember(Member member) {
		Connection conn = jdbctemplate.createConnection();
		int result = mDao.Updatemember(conn,member);
		if(result>0) {
			//성공 커밋
			jdbctemplate.commit(conn);
		}else {
			//실패 - 롤백
			jdbctemplate.rollback(conn);
		}		
		return result;
		
	}
	public int deleteMember(String memberId) {
		Connection conn =jdbctemplate.createConnection();
		int result = mDao.deletemember(conn,memberId);
		if(result>0) {
			//성공 커밋
			jdbctemplate.commit(conn);
		}else {
			//실패 - 롤백
			jdbctemplate.rollback(conn);
		}		
		return result;
	}
	public Member selectOneById(Member member) {
		Connection conn = jdbctemplate.createConnection();
		Member mOne = mDao.selectOneById(conn,member);
		jdbctemplate.close(conn);
		return mOne;
		
	}
	public Member selectOneById(String memberId) {
		//연결생성
		Connection conn = jdbctemplate.createConnection();
		Member member = mDao.selectOneById(conn,memberId);
		jdbctemplate.close(conn);
		return member;
	}
	
}
