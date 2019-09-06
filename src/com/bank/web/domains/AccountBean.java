package com.bank.web.domains;
import lombok.Data;

@Data
public class AccountBean extends MemberBean{
	
	private static final long serialVersionUID = 1L;
	private String accountNum, today, money;

	
}
