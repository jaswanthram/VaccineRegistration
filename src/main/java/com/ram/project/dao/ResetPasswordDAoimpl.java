package com.ram.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.ram.project.models.RegistrationEntity;

@Component
public class ResetPasswordDAoimpl implements ResetPasswordDAO {
	
	private SessionFactory sessionFactory;
	
	public ResetPasswordDAoimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("session factory object created");
	}



	@Override
	public boolean updatePasswordLogAtns(String mail, String password) {
		Session session=null;
		String hql = "FROM RegistrationEntity as re WHERE re.email= '"+mail+"' ";
		Transaction transaction=null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(hql);
			RegistrationEntity entity = (RegistrationEntity)query.uniqueResult();
			if(entity != null) {
				entity.setPassword(password);
				entity.setLoginAttempts(0);
				
				transaction = session.beginTransaction();
				session.update(entity);
				transaction.commit();
				System.out.println("data has been updated");
				return true;
			}else {
				return false;
			}
		}
		catch(HibernateException e){
			System.out.println("HibernateException occured");
			transaction.rollback();
			return false;
		}finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
	}

	

}
