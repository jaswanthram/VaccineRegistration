package com.ram.project.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.ram.project.models.MemberEntity;
import com.ram.project.models.RegistrationEntity;

@Component
public class Logindaoimpl implements Logindao {

	private SessionFactory sessionfactory;

	public Logindaoimpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		System.out.println("loginsession object got created");
	}

	@Override
	public String validateLoginData(String id, String password) {
		System.out.println("validateLoginData() method called");
		String flag = "";
		Session session = null;
		String hql = "from RegistrationEntity as ap where email ='" + id + "'";
		RegistrationEntity result = null;
		Query query = null;
		try {
			session = sessionfactory.openSession();
			query = session.createQuery(hql);
			result = (RegistrationEntity) query.uniqueResult();
			if (result != null) {
				if (result.getLoginAttempts() >= 3) {
					System.out.println(result);

					System.out.println("block condition");
					flag = "AccountBlocked";

				} else if (password.equals(result.getPassword())) {
					System.out.println("Data found " + result);
					flag = result.getUsername();
				} else {
					if (result.getLoginAttempts() < 3) {
						int i = result.getLoginAttempts();

						System.out.println(result);
						System.out.println(i);

						int atm = (i + 1);

						flag = result.getId() + " " + atm;
					}
				}
			} else {
				flag = "InvalidData";
			}
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
				System.out.println(flag);
				return flag;
			}
		}
		return null;
	}

	@Override
	public boolean maxValidAttempts(int id, int logAtns) {
		boolean flag = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionfactory.openSession();
			RegistrationEntity entity = session.get(RegistrationEntity.class, id);
			System.out.println(entity);
			entity.setLoginAttempts(logAtns);

			transaction = session.beginTransaction();
			session.update(entity);
			flag = true;
			transaction.commit();
			System.out.println(entity);

		} catch (HibernateException e) {
			transaction.rollback();
			System.out.println("Exception occured");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return flag;
	}

	@Override
	public List<MemberEntity> countTheMembers(String mail) {
		String hql="FROM MemberEntity m WHERE m.mailAddress = '"+mail+"' ";
		Session session=null;
		
		try {
			session = sessionfactory.openSession();
			
			Query query = session.createQuery(hql);
			List members = query.getResultList();
			
			
			return members;
		}finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
	}

}
