package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

public class Receiver {
	public static Command cmd = new Command();//클래스 변수라 초기화 해줘야 한다
	
	public static void init(HttpServletRequest request) {
		
		cmd = Commander.order(request);
	}
}
