package edu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

}
