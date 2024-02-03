package com.ram.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name ="registration")
@Entity
public class RegistrationEntity {
	
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="E_MAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="MOBILE_NO")
	private String mobile;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private String DOB;
	
	@Column(name="LOGIN_ATTEMPTS")
	private int loginAttempts;
	
	public RegistrationEntity() {
		System.out.println("POJO class got instantiated");
	}
	
	public RegistrationEntity(String username, String email, String password, String mobile, String gender, String DOB,int loginAttempts) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.gender = gender;
		this.DOB = DOB;
		this.loginAttempts=loginAttempts;
		System.out.println("request came to model class");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	@Override
	public String toString() {
		return "RegistrationEntity [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", gender=" + gender + ", DOB=" + DOB + ", loginAttempts=" + loginAttempts
				+ "]";
	}
	
}
