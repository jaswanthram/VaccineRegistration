package com.ram.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.ram.project.dao.DaoImpl;
import com.ram.project.models.RegistrationEntity;

@Component
public class DataValidation {
	
	private DaoImpl regDAO;
	private JavaMailSenderImpl javamail;
	
	@Autowired
	public DataValidation(DaoImpl regDAO,JavaMailSenderImpl javamail) {
		this.regDAO = regDAO;
		this.javamail=javamail;
		System.out.println("validation object is created");
	}

	public DataValidation() {
		System.out.println("validation object is created");
	}
	
	
	public String isDataValid(String username, String password1, String password2, String number, String email,String gender, String dOB) {
		String flag="NotValid";
		String validUsername = "^[a-zA-Z0-9 ]{5,30}+$";
		String validPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}+$";
		String validNumber = "^[6-9]{1}[0-9]{9}+$";
		
		if(username == null || !username.matches(validUsername)) {
			flag="InvalidUsername";
		}
		else if(password1 == null || !password1.matches(validPassword)) {
			if(password1== null) {
				flag="emptypwd";
			}
			else if( !(password1.equals(password2)) ) {
				flag="passwordMismatch";
			}else {
				flag="InvalidPassword";
			}
		}
		
		else if(number== null || !number.matches(validNumber)) {
			flag="Invalidnumber";
		}
		else if(email==null || email.isEmpty()) {
			flag="Invalidmail";
		}
		else if(gender==null || gender.isEmpty()) {
			flag="invalidgender";
		}
		else if(dOB==null || dOB.isEmpty()) {
			flag="invalidDOB";
		}else {
			flag="valid";
		}
		return flag;
	}
	

	public boolean saveTheData(String username, String email,String password1, String number,String gender, String dOB) {
		int logAttempts=0;
		RegistrationEntity entity = new RegistrationEntity(username, email, password1, number, gender, dOB,logAttempts);
		
		if(regDAO.saveData(entity)) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(email);
			message.setSubject("Registration conformation");
			message.setText("Registration has been successfull \n"
						+"use these Credentials to Login \n"
						+"Username= "+username+"\n"+"Password= "+password1+
						"\nThank you for registering with us");;
			System.out.println("req got to sendMail() method");
			try {
				javamail.send(message);
				System.out.println("mail is sent");
			} catch (MailException e) {
				System.out.println("Exception occured");
			}
			return true;
		}else {
			return false;
		}
	}
}
