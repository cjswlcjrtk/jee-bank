package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.enums.Action;

public class Commander{
		
	public static Command order(HttpServletRequest request) {
		Command cmd = new Command();
//		cmd = new MoveCommand(request); //-->다형성
		//SYSOUT찍을때
		String action = "";
		if(request.getParameter("action")==null) {
			action = "MOVE";						
		}else {
			action = Action.valueOf(
					request.getParameter("action")
							.toUpperCase()).toString();
		}
		
		System.out.println("액션 = " + action);
//		switch(Action.valueOf(request.getParameter("action")
//				.toUpperCase())) {
		try {
			switch(Action.valueOf(action)) {
			//파라매터로 날라온 소문자를 다 대문자로 바꾸라는 뜻으로 toUpperCase쓴다
			case LIST:
				cmd = new ListCommand(request);//오버라이딩
				break;
			case LOGIN:
				cmd = new LoginCommand(request);
				break;
			case JOIN:
				cmd = new CreatCommand(request);
				break;
			default :
				cmd = new MoveCommand(request);
		
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd;
		
	}

}
