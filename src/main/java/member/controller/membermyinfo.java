package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class membermyinfo
 */
@WebServlet("/member/myinfo.do")
public class membermyinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public membermyinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 이동 2가지
		//1.with Data
		//쿼리문 : SELECT * FROM MEMBER_TBL WHERE MEMBER_ID =?
		MemberService service = new MemberService();
		String memberId = request.getParameter("member_id");
		Member member = service.selectOneById(memberId);
		request.setAttribute("member",member);
		RequestDispatcher view = request.getRequestDispatcher("/member/myInfo.jsp");
		view.forward(request, response);
		//2.without Data(단순 페이지 이동)
		//reponse.sendRedirect("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
