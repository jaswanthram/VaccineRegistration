package com.ram.project.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ram.project.service.LoginService;

@Controller
public class LoginController {
	
	private LoginService logSer;

	@Autowired
	public LoginController(LoginService logSer) {
		this.logSer = logSer;
		System.out.println("login controller got created"+"\n");
	}

	@RequestMapping(value = "/LoginPage")
	public String loginData(@RequestParam String email, @RequestParam String password, Model model,HttpSession session) {
		
		System.out.println("login controller method called");
		String loginData = logSer.validLoginData(email, password);

		System.out.println(loginData);

		if (loginData.equals("ValidData")) {
			String loginDetails = logSer.validateLoginDetails(email, password);

			if (loginDetails.length()==1) {
				String al = loginDetails;
				int a = Integer.parseInt(al);
				System.out.println(a);
				
				model.addAttribute("attemptsleft", "Invalid password " + (4 - a) + " attempts left");
				return "/WEB-INF/LoginPage.jsp";
			} else if (loginDetails.equals("Blocked")) {
				
				model.addAttribute("blockedaccount", "Your account has been blocked...please reset your password");
				return "/WEB-INF/LoginPage.jsp";
				
			} else if (loginDetails.equals("InvalidData")) {
				
				model.addAttribute("doesnotexist", "Profile with entered email-id does not exist...please register");
				return "/WEB-INF/LoginPage.jsp";
				
			} else {
				String userName = loginDetails;
				String[] strings = userName.split(",");
				
				String username = strings[0];
				String count = strings[1];
				
				model.addAttribute("profile", username);
				model.addAttribute("Membercount", count);
				System.out.println("login successfull");
				
				session.setAttribute("valueKey", email);
				
				return "/WEB-INF/HomePage.jsp";
			}
		} 
		else if (loginData.equals("Invalidmail")) {
			
			model.addAttribute("nullMail", "-> Enter the E-mail");
			return "/WEB-INF/LoginPage.jsp";
		} 
		else if (loginData.equals("InvalidPassword")) {
			
			model.addAttribute("nullPassword", "-> Enter the Password");
			return "/WEB-INF/LoginPage.jsp";
		} 
		else {
			
			model.addAttribute("nullMail", "-> Enter the E-mail");
			model.addAttribute("nullPassword", "-> Enter the Password");
			return "/WEB-INF/LoginPage.jsp";
		}
	}
}
