package com.ram.project.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.ram.project.dao.ResetPasswordDAoimpl;

@Component
public class ResetService {
	
	private ResetPasswordDAoimpl dao;
	private JavaMailSenderImpl jmail;
	
	public ResetService(ResetPasswordDAoimpl dao,JavaMailSenderImpl jmail) {
		this.dao = dao;
		this.jmail=jmail;
		System.out.println("reset service object created");
	}

	public String validateResetPageData(String mail,String newPswd,String conNewPswd) {
		String flag="";
		String Validpswd="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()])[a-zA-Z0-9 !@#$%^&*()]{8,30}+$";
		if((mail==null || mail.isEmpty()) && (newPswd==null || newPswd.isEmpty()) && (conNewPswd==null ||conNewPswd.isEmpty())) {
			flag= "Allfieldsempty";
		}
		else if( (mail != null && !mail.isEmpty()) && (newPswd==null || newPswd.isEmpty()) && (conNewPswd==null ||conNewPswd.isEmpty()) ) {
			flag= "passwordEmpty";
		}
		else if( (newPswd!=null && !newPswd.isEmpty()) && (mail == null || mail.isEmpty()) ) {
			flag= "mailEmpty";
		}
		if((mail != null && !mail.isEmpty()) && (newPswd!=null && !newPswd.isEmpty()) || (conNewPswd!=null && !conNewPswd.isEmpty())) {
			if(!newPswd.matches(Validpswd)) {
				flag= "Invalidpswd";
			}
			else if( !(conNewPswd.isEmpty()) && (!newPswd.equals(conNewPswd)) || ( (conNewPswd.isEmpty()||conNewPswd==null) && !(newPswd.isEmpty()) )) {
				flag= "passwordMismatch";
			}
		}else {
			flag= "ValidData";
		}
		return flag;

	}

	public boolean updatingDataMethod(String mail, String newPassword, String conNewPswd) {
		boolean atns = dao.updatePasswordLogAtns(mail, newPassword);
		
		if(atns) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(mail);
			message.setSubject("Conformation mail");
			message.setText("Password reset has been successfull "+"\n"+"Your new password id :- "+newPassword);
			
			try {
				jmail.send(message);
				System.out.println("password reset mail sent");
				return true;
			}catch(Exception e) {
				System.out.println("Exception occured");
				return true;
			}
			
		}else {
			return false;
		}
		
	}
}
