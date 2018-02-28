package edu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.domain.Administrator;
import edu.service.AdminService;
import edu.util.GreenCarExp;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@Resource
	AdminService adminservice;
	@Resource
	HttpServletRequest req;
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String username, String passwd) {
		System.out.println("username " + username + "\npasswd " + passwd);
		Administrator administrator = adminservice.verifyAdmin(username, passwd);
		if(administrator == null) {
			System.out.println("wrong passwd");
			return "company/login.html";
		}
		//put in session
		req.getSession().setAttribute(GreenCarExp.ADMIN_IN_SESSION, administrator);
		System.out.println("right passwd");
		return "company/index.html";
	}
	
	@RequestMapping(value = "/changePassword.action", method = RequestMethod.POST)
	public String changePassword(String oldPass,String newPass) {
		HttpSession session=req.getSession();
		Administrator temp=(Administrator)session.getAttribute(GreenCarExp.ADMIN_IN_SESSION);
		if(temp==null){
			System.out.println("no such admin");
		}
		String userName=temp.getAdminAccount();
		System.out.println("hhh"+userName+" pass: "+oldPass);
		//System.out.println("username " + username + "\npasswd " + passwd);
		Administrator administrator = adminservice.verifyAdmin(userName, oldPass);
		if(administrator == null) {
			System.out.println("wrong password");
			return "company/changePassword.jsp";
		}
		//put in session
		adminservice.changePassword_s(userName, newPass);
		return "company/login.html";
	}


}
