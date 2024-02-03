package com.ram.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ram.project.service.ResetService;

@Controller
public class ResetController {
	
	private ResetService ser;
	
	@Autowired
	public ResetController(ResetService ser) {
		this.ser = ser;
		System.out.println("ResetController class object created"+"\n");
	}

	@RequestMapping(value = "/PasswordReset")
	public String resetRequest() {
		return "/WEB-INF/ResetPage.jsp";
	}
	
	@RequestMapping(value = "/forgotPassword")
	public String acceptResetPageData(@RequestParam String mail,@RequestParam String NewPassword,@RequestParam String conNewPswd,Model model) {
		
		String data = ser.validateResetPageData(mail, NewPassword, conNewPswd);
		
		if(data.equals("Allfieldsempty")) {
			model.addAttribute("nullMail", "-> Enter the E-mail id");
			model.addAttribute("nullnPswd","-> Enter the password");
			return "/WEB-INF/ResetPage.jsp";
		}
		else if(data.equals("passwordEmpty")) {
			model.addAttribute("nullnPswd","-> Enter the password");
			return "/WEB-INF/ResetPage.jsp";
		}
		else if(data.equals("mailEmpty")) {
			model.addAttribute("nullMail", "-> Enter the E-mail id");
			return "/WEB-INF/ResetPage.jsp";
		}
		else if(data.equals("Invalidpswd")) {
			model.addAttribute("nullnPswd", "-> password should contain atleast one lowercase \n-> password should contain atleast one uppercase \n-> password should contain atleast one numeric character \n-> password should contain atleast one special character \n-> Password should be minimun 8 characters");
			return "/WEB-INF/ResetPage.jsp";
		}
		else if(data.equals("passwordMismatch")) {
			model.addAttribute("nullnPswd", "-> Password does'nt match");
			model.addAttribute("confpaswd", "-> Password does'nt match");
			return "/WEB-INF/ResetPage.jsp";
		}
		else {
			System.out.println("valid data method called");
			boolean dataMethod = ser.updatingDataMethod(mail,NewPassword,conNewPswd);
			
			if(dataMethod) {
				model.addAttribute("successfullReset", "-> Password reset has been successfull....Check your mail");
				return "/WEB-INF/ResetPage.jsp";
			}else {
				model.addAttribute("successfullReset", "-> Profile does not exist with entered email...please enter valid email");
				return "/WEB-INF/ResetPage.jsp";
			}
			
		}
		
		
	}
}
