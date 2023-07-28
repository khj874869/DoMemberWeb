package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/member/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("member-pw");
		Member member = new Member(memberId,memberPw);
	    //select * from MEMBER_WEB  where MEMBER_ID = ?and MEMBER_PW = ?
		MemberService service= new MemberService();
		Member mOne = service.selectOneById(member);
		
		if(mOne!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			request.setAttribute("msg","전송성공했습니다.");
			request.setAttribute("URL", "/index.jsp");
			RequestDispatcher view = request.getRequestDispatcher("/member/ServiceSuccess.jsp");
			view.forward(request, response);

		}else {
			request.setAttribute("msg","전송실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/member/ServiceFail.jsp");
			view.forward(request, response);			
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
