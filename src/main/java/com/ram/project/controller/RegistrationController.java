package com.ram.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ram.project.service.DataValidation;

@Controller
public class RegistrationController {

	private DataValidation valid;
	
	@Autowired
	public RegistrationController(DataValidation valid) {
		this.valid = valid;
		System.out.println("registration controller class object is created"+"\n");
	}
	
	@RequestMapping(value = "/goToRegister")
	public String goToRegisterPage() {
		return "/WEB-INF/Register.jsp";
	}
	
	@RequestMapping(value = "/goToLogin")
	public String goToLoginPage() {
		return "/WEB-INF/LoginPage.jsp";
	}
	
	@RequestMapping(value = "/SaveApplication")
	public String saveData(@RequestParam String Username,@RequestParam String Password1,@RequestParam String Password2,@RequestParam String Number,@RequestParam String Email,@RequestParam String gender,@RequestParam String DOB,Model model) {
	
		if(valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("valid")){
			System.out.println("hello mCHA");
			if(valid.saveTheData(Username, Email,Password1, Number, gender, DOB)) {
				model.addAttribute("response", "Data is valid && saved to data base");
				return  "/WEB-INF/Register.jsp";
			}
			else {
				model.addAttribute("response", "Data is Invalid");
				return   "/WEB-INF/Register.jsp";
			}
			
		}
		else if(valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("InvalidUsername")) {
			model.addAttribute("InvalidUsername", "-> Username should'nt contain special characters");
			model.addAttribute("response", "Data is Invalid");
			return "/WEB-INF/Register.jsp";
		}
		else if((valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("emptypwd"))) {
			model.addAttribute("InvalidPassword", "-> password should not be empty");
			return  "/WEB-INF/Register.jsp";
			
		}
		else if(valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("InvalidPassword")) {
			model.addAttribute("invalidPassword", "-> password should contain atleast one lowercase \n-> password should contain atleast one uppercase \n-> password should contain atleast one numeric character \n-> password should contain atleast one special character");
			model.addAttribute("response", "Data is Invalid");
			return  "/WEB-INF/Register.jsp";
		}
		else if((valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("passwordMismatch"))) {
			model.addAttribute("mismatchpwd", "-> password should match");
			return "/WEB-INF/Register.jsp";
		}
		else if(valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("Invalidnumber")) {
			model.addAttribute("Invalidnumber", "->Invalid mobile number");
			return "/WEB-INF/Register.jsp";
		}
		else if(valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("Invalidmail")) {
			model.addAttribute("Invalid", "->Invalid e-mail address");
			return "/WEB-INF/Register.jsp";
		}
		else if(valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("invalidgender")) {
			model.addAttribute("InvalidGender", "->Invalid gender");
			return "/WEB-INF/Register.jsp";
		}
		else if(valid.isDataValid(Username, Password1, Password2, Number, Email, gender, DOB).equals("invalidDOB")) {
			model.addAttribute("InvalidDOB", "->Invalid date of birth");
			return "/WEB-INF/Register.jsp";
		}
		else {
			model.addAttribute("response", "Data is Invalid");
			return  "/WEB-INF/Register.jsp";
		}
	}
}
