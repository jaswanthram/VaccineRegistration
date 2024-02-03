package com.ram.project.dao;

import java.util.List;

import com.ram.project.models.MemberEntity;

public interface Logindao {
	String validateLoginData(String id,String password);
	boolean maxValidAttempts(int id,int logAtns);
	List<MemberEntity> countTheMembers(String mail);
}
