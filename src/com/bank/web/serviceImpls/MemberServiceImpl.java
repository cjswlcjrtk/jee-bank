package com.bank.web.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import com.bank.web.daoImpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{
	
	private List<CustomerBean> customers;
	private List<EmployeeBean> employees;
	private MemberDAO dao;
	private CustomerBean cust;
	
	
	
	public MemberServiceImpl() {
		customers = new ArrayList<>();
		employees = new ArrayList<>();
		dao = new MemberDAOImpl();
		cust = new CustomerBean();
				
	}
	@Override
	public void join(CustomerBean param) {
		dao.insertCustomer(param);
	}

	@Override
	public void register(EmployeeBean param) {
		employees.add(param);
	}

	@Override
	public List<CustomerBean> findAllCustomers() {
		return customers;
	}

	@Override
	public List<EmployeeBean> findAllEmployees() {
		return employees;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> members = new ArrayList<>();
		int count = 0;
		for(CustomerBean c : customers) {			
			if(name.equals(c.getId())) {
				count++;
				break;
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getId())) {
				count++;
				break;
			}
		}
		
		int j = 0;
		for(CustomerBean c : customers) {			
			if(name.equals(c.getId())) {
				members.add(c);
				j++;
				if(j==count) {
					return members;
				}
			}
		}
		for(EmployeeBean e : employees) {
			if(name.equals(e.getId())) {
				members.add(e);
				j++;
				if(j==count) {
					break;
				}
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean m = new MemberBean();
		for(CustomerBean c : customers) {			
			if(id.equals(c.getId())) {
				m = c;
				return m;
			}
		}
		for(EmployeeBean e : employees) {
			if(id.equals(e.getId())) {
				m = e;
				break;
			}
		}
		return m;
	}
	
	
	@Override
	public CustomerBean login(MemberBean param) {
		System.out.println("cust=" + cust);
//		System.out.println("12312111111="+dao.login(cust));
//		if(param.getId().equals(dao.login(cust).getId())
//				&&
//				param.getPw().equals(dao.login(cust).getPw())) {
//			
//		}
//		System.out.println("cust=" + cust);
		cust = dao.login(cust);
		System.out.println("cust=" + cust);
		return cust;
	}
	
//	@Override
//	public boolean login(MemberBean param) {
//		System.out.println("잘타나나나");
//		boolean flag  = false;
//		if(param.getId().equals(dao.login(cust).getId())
//				&&
//				param.getPw().equals(dao.login(cust).getPw())) {
//			flag = true;			
//		}else {
//			flag = false;
//	}
//		
//		System.out.println(dao.login(cust));
//		return flag;
//	}
	
//	@Override
//	public boolean login(MemberBean param) {
//		boolean flag  = false;
//		MemberBean m = findById(param.getId());
//		for(CustomerBean c : customers) {			
//			if(m.equals(c.getId())) {
//				flag = true;
//				break;
//			}
//		}
//		for(EmployeeBean e : employees) {
//			if(m.equals(e.getId())) {
//				flag = true;
//				break;
//			}
//		}		
//		return flag;
//	}
	
	
	@Override
	public int countCustomers() {
		return customers.size();
	}

	@Override
	public int countEmployees() {
		return employees.size();
	}

	@Override
	public boolean existId(String id) {
		MemberBean m = findById(id);
		return (customers.contains(m) || employees.contains(m));
	}

	@Override
	public void updatePass(MemberBean param) { 
		String id = param.getId();
		String oldPw = param.getPw().split(",")[0];
		String newPw = param.getPw().split(",")[1];
		MemberBean m = findById(id);
		if(m.getPw().equals(oldPw)) {
			int idx = (employees.contains(m)) 
					? employees.indexOf(m)
							:customers.indexOf(m);
			if(employees.contains(m)) {
				employees.get(idx).setPw(newPw);
			}else {
				customers.get(idx).setPw(newPw);
			}
		}
	}

	@Override
	public boolean deleteMember(MemberBean param) {
		MemberBean m = findById(param.getId());
		return (employees.contains(m)) 
				? employees.remove(m)
						:customers.remove(m);
	}
	
		
	

}
