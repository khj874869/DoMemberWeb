package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class memberUpdate
 */
@WebServlet("/member/memberUpdate.do")
public class memberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("id");
		String memberPw = request.getParameter("pw");
		String memberGender = request.getParameter("gender");
		String memberEmail=request.getParameter("email");
		String memberPhone=request.getParameter("phone");
		String memberAddress=request.getParameter("addr");
		String memberHobby=request.getParameter("hobby");
		//UPDATE MEMBER_WEB SET MEMBER_PW = ?,MEMBER_PHONE=?,MEMBER_ADDRESS=?,MEMBER_HOBBY=? WHERE MEMBER_ID = ?, UPDATE_DATE =SYSDATE;
		MemberService service = new MemberService();
		Member member=new Member(memberId, memberPw, memberGender, memberEmail, memberPhone, memberAddress, memberHobby);
//		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		int result = service.updateMember(member);
		if(result>0) {
			//성공메인페이지
			response.sendRedirect(".index.jsp");
		}
		else {
			request.setAttribute("msg", "회원정보 수정이 완료되지 못 했습니다.");
			request.getRequestDispatcher("/member/serviceFail.jsp").forward(request,response);
			//실패
		}
	}

}
