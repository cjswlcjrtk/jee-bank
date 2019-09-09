package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceImpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class CreatCommand extends MoveCommand{

	public CreatCommand(HttpServletRequest request) throws Exception {
		super(request);
	}
	
	@Override
	public void execute() {
		super.execute();
		System.out.println("여기타다?");
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		
		param.setId(request.getParameter("id"));		
		param.setPw(request.getParameter("pw"));
		param.setSsn(request.getParameter("ssn"));
		param.setName(request.getParameter("name"));
		param.setCredit(request.getParameter("credit"));
		
		System.out.println("회원정보" + request.getParameter("id"));	
		System.out.println("회원정보" + request.getParameter("pw"));	
		System.out.println("회원정보" + request.getParameter("ssn"));	
		System.out.println("회원정보" + request.getParameter("name"));	
		System.out.println("회원정보" + request.getParameter("credit"));	
		System.out.println("회원정보" + param.toString());			
		service.join(param);
		Receiver.cmd.setPage("login");
		System.out.println("회원 가입 후 갈 페이지 : " + Receiver.cmd.getView());
	}

}
