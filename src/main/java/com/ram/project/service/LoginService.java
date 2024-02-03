package com.ram.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.ram.project.dao.Logindaoimpl;
import com.ram.project.models.MemberEntity;

@Component
public class LoginService {

	private Logindaoimpl dao;
	private JavaMailSenderImpl mail;

	@Autowired
	public LoginService(Logindaoimpl dao, JavaMailSenderImpl mail) {
		this.dao = dao;
		this.mail = mail;
		System.out.println("login validation object created");
	}

	public String validLoginData(String email, String password) {
		System.out.println("login service method called");

		if ((email != null && !email.isEmpty()) && (password != null && !password.isEmpty())) {
			return "ValidData";
		} 
		else if ((email == null || email.isEmpty()) && (password == null || password.isEmpty())) {
			return "Invalid";
		}
		else if (email == null || email.isEmpty()) {
			return "Invalidmail";
		}
		else {
			return "InvalidPassword";
		}
	}

	public String validateLoginDetails(String email, String password) {
		String flag = "";
		
		List<MemberEntity> members = dao.countTheMembers(email);
		
		int count=0;
		for(MemberEntity num : members) {
			count++;
		}
		String validCredentials = dao.validateLoginData(email, password);

		System.out.println(validCredentials);

		if (validCredentials.length() == 3) {
			String idml = validCredentials;
			System.out.println("hello world");

			String[] strings = idml.split(" ");
			String id = strings[0];
			int i = Integer.parseInt(id);
			System.out.println(i);

			String loAtns = strings[1];
			int j = Integer.parseInt(loAtns);
			System.out.println(j);

			if (dao.maxValidAttempts(i, j)) {
				flag = loAtns;
			}
		} else if (validCredentials.equals("AccountBlocked")) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(email);
			mailMessage.setSubject("Account Blocked");
			mailMessage.setText(
					"Your Account has been blocked due to entering incorrect password multiple(more than 3 times) times. \nTo unblock your account please try to contact admin \n\nThank you.");

			try {
				mail.send(mailMessage);
				System.out.println("mail is sent");
			} catch (MailException e) {
				System.out.println("Exception occured");
			}

			flag = "Blocked";
		} 

		else if (validCredentials.equals("InvalidData")) {
			System.out.println("Invalid data");
			flag = "InvalidData";
		}
		else {
			String userName = validCredentials; 
				System.out.println(userName);
				flag = userName+","+count;
		}

		return flag;
	}
}
