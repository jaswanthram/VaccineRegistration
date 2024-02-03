package com.ram.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ram.project.dao.AddMemberDaoImpl;
import com.ram.project.models.MemberEntity;

@Component
public class AddMemberService {
	
	private AddMemberDaoImpl memberDao;
	
	@Autowired
	public AddMemberService(AddMemberDaoImpl memberDao) {
		this.memberDao = memberDao;
		System.out.println("AddMemberService class object is created");
	}

	public String validMemberInfo(String Name, String Gender, String Dob, String IDProof,String IdproofNo, String VaccineType, String dose,String mail) {
		String validUserName="^[a-zA-Z0-9 ]+$";
		String flag="";
		if((Name != null && !(Name.isEmpty())) && (Gender!= null) && (Dob!=null && !(Dob.isEmpty())) && (IDProof!=null && !(IDProof.isEmpty())) && (VaccineType!=null) && (IdproofNo != null && !(IdproofNo.isEmpty())) && !(dose.isEmpty())) {
			
			if(!Name.matches(validUserName)) {
				return "InvalidUsername";
			}
			MemberEntity entity = new MemberEntity(Name,Gender,Dob,IDProof,IdproofNo,VaccineType,dose,mail);
			
			System.out.println(entity+"\n");
			
			List<MemberEntity> theMembers = memberDao.countTheMembers(mail);
			
			int count=0;
			
			for(MemberEntity member : theMembers) {
				count++;
			}
			
			System.out.println(count+"\n");
			
			if(count<4) {
				
				boolean Saveddao = memberDao.SaveMemberDetails(entity,mail);
				if(Saveddao) {
					flag= "allDataValid";
				}else {
					flag= "InvalidData";
				}
				
			}else {
				flag="limitExceeded";
			}
			
		}
		else if(Name==null || Name.isEmpty()) {
			flag= "InvalidName";
		}
		else if(Dob==null || Dob.isEmpty()) {
			flag="NullDob";
		}
		else if(IDProof==null || IDProof.isEmpty()) {
			flag="NullIdProof";
		}
		else if(IdproofNo==null || IdproofNo.isEmpty()) {
			flag="IdproofNoNull";
		}
		else {
			flag= "DataInvalid";
		}
		return flag;
	}
	
	public ArrayList<MemberEntity> ViewDataInDb(String email){
		ArrayList<MemberEntity> fromDb = (ArrayList<MemberEntity>) memberDao.getDataFromDb(email);
		if(fromDb==null) {
			return null;
		}else {
			return fromDb;
		}
	}

	public MemberEntity getMemberById(int id) {
		MemberEntity memberEntity = memberDao.getMember(id);
		return memberEntity;
	}

	public boolean updateMember(int id,String nameChange, String genderChange, String bdayChange, String proofChange,
			String proofNumberChange, String vaccineChange, String doseChange, String emailID) {
		
		MemberEntity entity = new MemberEntity(id,nameChange, genderChange, bdayChange, proofChange, proofNumberChange, vaccineChange, doseChange, emailID);
		
		System.out.println(entity);
		boolean member = memberDao.updateMember(entity);
		
		return member;
	}
	
	public boolean editingData(int id,String Name, String Gender, String Dob, String IDProof,String IdproofNo, String VaccineType, String dose,String mail) {
		String validUserName="^[a-zA-Z0-9 ]+$";
		
		System.out.println("validating values"+"\n");
		
		if((Name != null && !(Name.isEmpty())) && (Gender!= null) && (Dob!=null && !(Dob.isEmpty())) && (IDProof!=null && !(IDProof.isEmpty())) && (VaccineType!=null) && (IdproofNo != null && !(IdproofNo.isEmpty())) && !(dose.isEmpty())) {
			
			if(!Name.matches(validUserName)) {
				return false;
			}else {
				return true;
			}
		}else {
			return false;
		}
	}

	public boolean deleteTheMember(int id) {
		
		boolean entity = memberDao.deleteMemberEntity(id);
		
		if(entity) {
			return true;
		}else {
			return false;
		}

	}
}	
