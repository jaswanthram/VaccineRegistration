package com.ram.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "member_table")
@Entity
public class MemberEntity {
	
	public MemberEntity() {
		System.out.println("default constructor of member entity");
	}
	
	@Id
	@Column(name="MEMBER_ID")
	private int id;
	
	@Column(name = "MEMBER_NAME")
	private String name;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name="DATE_OF_BIRTH")
	private	String dob;
	
	@Column(name = "ID_PROOF")
	private String idProof;
	
	@Column(name = "ID_PROOF_NO")
	private String proofNumber;
	
	@Column(name="VACCINE_TYPE")
	private String vaccineType;
	
	@Column(name = "DOSE")
	private String dose;
	
	@Column(name = "USER_EMAIL")
	private String mailAddress;

	public MemberEntity(String name, String gender, String dob, String idProof, String proofNumber,
			String vaccineType, String dose, String mailAddress) {
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.proofNumber = proofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.mailAddress = mailAddress;
		System.out.println("request got to entity class");
	}
	
	
	public MemberEntity(int id, String name, String gender, String dob, String idProof, String proofNumber,
			String vaccineType, String dose, String mailAddress) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.idProof = idProof;
		this.proofNumber = proofNumber;
		this.vaccineType = vaccineType;
		this.dose = dose;
		this.mailAddress = mailAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getProofNumber() {
		return proofNumber;
	}

	public void setProofNumber(String proofNumber) {
		this.proofNumber = proofNumber;
	}

	public String getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", idProof="
				+ idProof + ", proofNumber=" + proofNumber + ", vaccineType=" + vaccineType + ", dose=" + dose
				+ ", mailAddress=" + mailAddress + "]";
	}
	
}
