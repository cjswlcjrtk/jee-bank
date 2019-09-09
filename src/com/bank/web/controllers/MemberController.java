package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.command.Sender;
import com.bank.web.command.Command;
import com.bank.web.command.MoveCommand;
import com.bank.web.command.Order;
import com.bank.web.command.Receiver;
//import com.bank.web.daoImpls.MemberDAOImpl;
//import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceImpls.MemberServiceImpl;
import com.bank.web.services.MemberService;


@WebServlet("/customer.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
//		System.out.println("MemberController에 도착함");
//		CustomerBean  param = new CustomerBean(); 
//		MemberService service = new MemberServiceImpl();
		Receiver.init(request);
		Receiver.cmd.execute();
//		if(Receiver.cmd.getAction()==null) {
//			Receiver.cmd.setPage();			
//		}
//		switch(Receiver.cmd.getAction()) {	
//		case "join" :	
//			System.out.println("여기타다?");
//			String id = request.getParameter("id");
//			String pw = request.getParameter("pw");
//			String name = request.getParameter("name");
//			String ssn = request.getParameter("ssn");
//			String credit = request.getParameter("credit");
//			
//			param.setCredit(credit);
//			param.setId(id);
//			param.setName(name);
//			param.setPw(pw);
//			param.setSsn(ssn);
//			System.out.println("회원정보" + param.toString());			
//			service.join(param);
//			Receiver.cmd.setPage("login");
//			Receiver.cmd.execute();
//			break;
//		case "login" :	
//			id = request.getParameter("id");
//			pw = request.getParameter("pw");
//			param.setId(id);
//			param.setPw(pw);
//			System.out.println("id확인 = " + id);
//			System.out.println("pw확인 = " + pw);
//			System.out.println("로그인 서비스 진입후 아이디, 비번");
//
//			CustomerBean cust = service.login(param);
//	
//			if(cust == null) {
//				Receiver.cmd.setPage("login");
//			}else{
//				Receiver.cmd.setPage("myPage");
//			}
//			request.setAttribute("customer", cust);
//			Receiver.cmd.execute();			
//			break;
//		case "existId" :
//			break;
//		}
		Sender.forward(request, response);
		
// 아래 코드처럼 적게 되면 servlet이 늘어나고 결국엔 무거워지고 이게 쌓이면 다운, 터져버린다.
//		절대 이렇게 하지 말것
//		RequestDispatcher rd = request.getRequestDispatcher(
//				String.format("WEB-INF/views/customer/%s.jsp", 
//						request.getParameter("action")));
//		
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		String ssn = request.getParameter("ssn");
//		String credit = request.getParameter("credit");
//		CustomerBean  param = new CustomerBean(); 
//		param.setCredit(credit);
//		param.setId(id);
//		param.setName(name);
//		param.setPass(pw);
//		param.setSsn(ssn);
//		System.out.println("회원정보" + param.toString());
//		MemberService service = new MemberServiceImpl();
//		service.join(param);
//		
//		rd.forward(request, response);	
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
