package com.ram.project.dao;

import java.util.List;

import com.ram.project.models.MemberEntity;

public interface AddMemberDao {

	boolean SaveMemberDetails(MemberEntity entity,String mail);
	List<MemberEntity> countTheMembers(String mail);
	List<MemberEntity> getDataFromDb(String mail);
	MemberEntity getMember(int id);
	boolean updateMember(MemberEntity entity);
	boolean deleteMemberEntity(int id);
}
