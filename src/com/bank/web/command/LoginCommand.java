package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceImpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class LoginCommand extends MoveCommand {
	public LoginCommand(HttpServletRequest request) throws Exception{
		super(request);
	}

	@Override
	public void execute() {
		super.execute();
		CustomerBean param = new CustomerBean();
		MemberService service = new MemberServiceImpl();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		param.setId(id);
		param.setPw(pw);	
        System.out.printf("로그인  서비스 진입 후 아이디 %s , 비번 %s", id,  pw);
        CustomerBean cust = service.login(param);
        String domain = "customer";
        String page = "login";
        System.out.println("#####cust#####"+cust);
        System.out.println("cust.getId()" + cust.getId());
        System.out.println("param.getId()" + param.getId());
        System.out.println("cust.getPw()" + cust.getPw());
        System.out.println("param.getPw()" + param.getPw());
        
        if(cust.getId().equals(param.getId())
        		&&
        		cust.getPw().equals(param.getPw())) {
        	System.out.println("######cust1");
        	Receiver.cmd.setPage("myPage");
        }else {
        	System.out.println("######cust2");
        	Receiver.cmd.setView(String.format
        			(Constants.VIEW_PATH, domain, page));
        }
        
//		if(cust==null) {
//			page = "login";
//		}else {
//			page = "mypage";
//		}
		request.setAttribute("customer", cust);
		System.out.println("page#######page=="+page);
		
		System.out.println("로그인 후 갈 페이지 : " + Receiver.cmd.getView());
		
	}
	
	
	

}
