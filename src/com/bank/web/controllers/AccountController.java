package com.bank.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.*;
import com.bank.web.serviceImpls.AccountServiceImpl;;

@WebServlet("/account.do")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("account로 잘 오나~");
		AccountService service = new AccountServiceImpl();
		String money = request.getParameter("money");
		AccountBean a = new AccountBean();
		
//		service.createAccount(money);
		a.setMoney(money);
//		System.out.println("계좌번호" + service.toString());
		RequestDispatcher rd = 
				request.getRequestDispatcher("WEB-INF/views/account/account.jsp");
		rd.forward(request, response);

		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
