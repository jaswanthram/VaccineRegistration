package com.ram.project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ram.project.models.MemberEntity;
import com.ram.project.service.AddMemberService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
public class AddMemberController {
	
	public int MemberId;
	public String emailID;
	private AddMemberService Service;
	
	@Autowired
	public AddMemberController(AddMemberService Service) {
		this.Service = Service;
		System.out.println("Add member controller is created"+"\n");
	}
	
	@RequestMapping(value = "/deleteTheMember/{id}")
	public String deleteMember(@PathVariable int id,Model model) {
		System.out.println("request came to confirmation method");
		
		boolean member = Service.deleteTheMember(id);
		
		if(member) {
			model.addAttribute("deleteResponse", "delete operation successfull");
			return "/WEB-INF/deleteResponse.jsp";
		}else {
			model.addAttribute("deleteResponse", "delete operation failed");
			return "/WEB-INF/deleteResponse.jsp";
		}
		
	}
	
	@RequestMapping(value = "/goToEditPage/{id}")
	public String goToEdit(@PathVariable int id,Model model) {
		System.out.println("request got to edit method "+id);
		MemberEntity byId = Service.getMemberById(id);
		model.addAttribute("changeID", id);
		model.addAttribute("changeName", byId.getName());
		model.addAttribute("changeGender", byId.getGender());
		model.addAttribute("changeBirthDay", byId.getDob());
		model.addAttribute("changeIdproof", byId.getIdProof());
		model.addAttribute("changeIdproofNumber", byId.getProofNumber());
		model.addAttribute("changeVaccine", byId.getVaccineType());
		model.addAttribute("changeDoseType", byId.getDose());
		System.out.println("request came to edit page");
		
		return "/WEB-INF/UpdatePage.jsp";
	}
	
	@RequestMapping(value = "/updateData")
	public String editMember(@RequestParam int changeID, @RequestParam String nameChange,@RequestParam String GenderChange,@RequestParam String BDayChange,@RequestParam String ProofChange,@RequestParam String ProofNumberChange,@RequestParam String vaccineChange,@RequestParam String DoseChange,Model model) {
		System.out.println("request got to editMember method");
		
		boolean memberInfo = Service.editingData(changeID,nameChange, GenderChange, BDayChange, ProofChange, ProofNumberChange, vaccineChange, DoseChange,emailID);
		
		System.out.println(memberInfo);
		if(memberInfo) {
			boolean member = Service.updateMember(changeID,nameChange,GenderChange,BDayChange,ProofChange,ProofNumberChange,vaccineChange,DoseChange,emailID);
				
			System.out.println(member+"\n");
			if(member) {
				model.addAttribute("updateLogic", "Data has been updated");
			}else {
				model.addAttribute("updateLogic", "error occured");
			}
			 
		}
		return "/WEB-INF/AddMember.jsp";
	}
	
	@RequestMapping(value = "/addMember")
	public String addMemberRequest(HttpSession session) {
		
		emailID = (String)session.getAttribute("valueKey");
		System.out.println(emailID);
		
		return "/WEB-INF/AddMember.jsp";
	}
	
	@RequestMapping(value = "/ViewAllMembers")
	public String ViewAllMembers(Model model) {
		System.out.println("request came to ViewAllMembers method");
		
		String id = emailID;
		System.out.println(id+"\n");
		ArrayList<MemberEntity> db = Service.ViewDataInDb(id);
		
		if(db==null) {
			model.addAttribute("allData", "You does not added any members..");
			return "/WEB-INF/AddMember.jsp";
		}
		else {
			model.addAttribute("membername", "Member Name");
			model.addAttribute("gender", "Gender");
			model.addAttribute("dob", "Date-of-birth");
			model.addAttribute("Idproof", "Id-proof");
			model.addAttribute("proofno", "Id-proof Number");
			model.addAttribute("typeofvacc", "Vaccine Type");
			model.addAttribute("dose", "Dose number");
			model.addAttribute("editData", "EDIT");
			model.addAttribute("deleteData", "DELETE");
		
			model.addAttribute("allData",db);
			
			System.out.println("table data is displayed");
			return "/WEB-INF/AddMember.jsp";
		}
		
		
	}
	
	@RequestMapping(value = "/addTheMember")
	public String addTheMember(@RequestParam String name,@RequestParam String gender,
								@RequestParam String dob,@RequestParam String IdProof,@RequestParam String IdProofNumber,
								@RequestParam String Vaccinetype,@RequestParam String dose,Model model,HttpSession session)  {
		
		System.out.println(emailID);
		String email = emailID;
		System.out.println(email);
	
		
		String b = Service.validMemberInfo(name, gender, dob, IdProof,IdProofNumber, Vaccinetype, dose,email);
		
		System.out.println(b);
		if(b.equals("allDataValid")) {
			model.addAttribute("response", "Member is saved successfully");
			return "/WEB-INF/AddMember.jsp";
		}
		else if(b.equals("InvalidName")) {
			model.addAttribute("nameisnull", "-> Enter the username");
			return "/WEB-INF/AddMember.jsp";
		}
		else if(b.equals("InvalidUsername")) {
			model.addAttribute("nameisnull", "-> Username should not contain special characters");
			return "/WEB-INF/AddMember.jsp";
		}
		else if(b.equals("NullDob")) {
			model.addAttribute("Dobisnull", "-> Enter the Date of birth");
			return "/WEB-INF/AddMember.jsp";
		}
		else if(b.equals("NullIdProof")) {
			model.addAttribute("IdproofNull", "-> Select the Id Proof");
			return "/WEB-INF/AddMember.jsp";
		}
		else if(b.equals("IdproofNoNull")) {
			model.addAttribute("IdproofNumNull", "-> Enter the ID proof Number");
			return "/WEB-INF/AddMember.jsp";
		}
		else if(b.equals("limitExceeded")) {
			model.addAttribute("overloading", "INVALID REQUEST.....you cannot add more than four members");
			return "/WEB-INF/AddMember.jsp";
		}
		else {
			model.addAttribute("response", "data is Invalid and not saved");
			return "/WEB-INF/AddMember.jsp";
		}
		
	}
}
