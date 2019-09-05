package com.bank.web.serviceImpls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService{
	
	private List<AccountBean> accounts;
	
	public AccountServiceImpl() {
		accounts = new ArrayList<>();
	}

	@Override
	public void createAccount(String money) {
		AccountBean acc = new AccountBean();
		acc.setAccountNum(createAccountNum());
		acc.setMoney(money);
		acc.setToday(findDate());
		System.out.println(acc);
		accounts.add(acc);
	}

	@Override
	public String createAccountNum() {
		
		String accountNum = "";
		Random ran = new Random();
		for(int i=0; i<9; i++) {
			accountNum += (i==4) ? "-" : ran.nextInt(10);
		}		
		System.out.println(accountNum);
		return accountNum;
	}

	@Override
	public List<AccountBean> findAll() {
		return accounts;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean a = new AccountBean();
		for(AccountBean ac : accounts) {
			if(accountNum.equals(ac.getAccountNum())) {
				a =ac;
				break;
			}
		}
		return a;
	}

	@Override
	public int countAccounts() {
		return accounts.size();
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		return accounts.contains(findByAccountNum(accountNum));
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		for(AccountBean ac : accounts) {
			if(param.getAccountNum().equals(ac.getAccountNum())) {
				ac.setMoney(ac.getMoney() + param.getMoney());
			}
		}
		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		for(AccountBean ac : accounts) {
			if(param.getAccountNum().equals(ac.getAccountNum())) {
//				ac.setMoney(ac.getMoney() - param.getMoney());
			}
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		accounts.remove(findByAccountNum(accountNum));
	}



}
