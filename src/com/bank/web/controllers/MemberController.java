package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.bank.web.daoImpls.MemberDAOImpl;
//import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceImpls.MemberServiceImpl;
import com.bank.web.services.MemberService;


@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, 
	IOException {
		System.out.println("MemberController에 도착함");
	
//		String action = request.getParameter("action");
//		System.out.println("action"+action);
//		String dest = request.getParameter("action");
//		System.out.println("dest"+dest);
//		
		//switch가 command 패턴이다.
		CustomerBean  param = new CustomerBean(); 
//		MemberDAO dao = new MemberDAOImpl();
		MemberService service = new MemberServiceImpl();
		switch(request.getParameter("action")) {	
		
		case "move" :
			System.out.println(request.getParameter("directory"));
			System.out.println( request.getParameter("dest"));
			request.getRequestDispatcher
	         (String.format(
	        		 Constants.VIEW_PATH,
	        		 request.getParameter("directory"),
	                request.getParameter("dest"))).forward(request, response);
			break;
		case "join" :	
			System.out.println("여기타다?");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			String credit = request.getParameter("credit");
			
			param.setCredit(credit);
			param.setId(id);
			param.setName(name);
			param.setPw(pw);
			param.setSsn(ssn);
			System.out.println("회원정보" + param.toString());
			
			service.join(param);
			request.getRequestDispatcher
	         (String.format(
	        		 Constants.VIEW_PATH,
	        		 request.getParameter("directory"),
	                request.getParameter("dest"))).forward(request, response);
			
			break;
		case "login" :	
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			param.setId(id);
			param.setPw(pw);
			System.out.println("id확인 = " + id);
			System.out.println("pw확인 = " + pw);
			System.out.println("로그인 서비스 진입후 아이디, 비번");
//			service.login(param);
//			if(service.login(param)) {
//				dao.login(param);
//				request.setAttribute("customer",param);
//				request.getRequestDispatcher
//		         (String.format(
//		        		 Constants.VIEW_PATH,
//		        		 request.getParameter("directory"),
//		                request.getParameter("dest"))).forward(request, response);
//				
//			}else {
//				request.getRequestDispatcher
//		         (String.format(
//		        		 Constants.VIEW_PATH,
//		        		 request.getParameter("directory"),
//		        		 "login")).forward(request, response);
//				
//			}
			
			
			
			
//			service.login(param);
			CustomerBean cust = service.login(param);
			System.out.println("4==>" + param.getId());
			
			System.out.println("5==>" + equals(cust.getId()));
			System.out.println("6==>"+cust.getId());
			if(param.getId().equals(cust.getId())
					&&
					param.getPw().equals(cust.getPw())) {
				System.out.println("<<<<<8>>>>>");
				request.setAttribute("customer",param);
				request.getRequestDispatcher
				(String.format(
	        		 Constants.VIEW_PATH,
	        		 request.getParameter("directory"),
	                request.getParameter("dest"))).forward(request, response);
			
			}else {
				System.out.println("<<<<<9>>>>>");	
			request.getRequestDispatcher			
	         (String.format(
	        		 Constants.VIEW_PATH,
	        		 request.getParameter("directory"),
	        		 "login")).forward(request, response);
			
			}				
			break;
		case "existId" :
			break;
		}
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
