package com.bank.web.daoImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;

public class MemberDAOImpl implements MemberDAO{
	
	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			File file = new File(Constants.FILE_PATH+"customer0905.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = 
					new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format(
					"%s,%s,%s,%s,%s", 
					param.getId(),
					param.getPw(),					
					param.getSsn(),
					param.getName(),
					param.getCredit()));
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		
	}

	@Override
	public CustomerBean login(CustomerBean param) {
		System.out.println("11111");
		try {
			System.out.println("123123123");
			File file = new File(Constants.FILE_PATH+"customer0905.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg = reader.readLine();
			reader.close();
			String[] info = msg.split(",");
			param.setId(info[0]);
			param.setPw(info[1]);
			param.setSsn(info[2]);
			param.setName(info[3]);
			param.setCredit(info[4]);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return param;
	}

}
