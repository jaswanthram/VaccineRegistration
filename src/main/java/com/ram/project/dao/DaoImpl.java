package com.ram.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ram.project.models.RegistrationEntity;

@Component
public class DaoImpl implements RegistrationDAO{
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public DaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("session factory object got created");
	}


	@Override
	public boolean saveData(RegistrationEntity reg) {
		System.out.println("request came to savedata method");
		Session session=null;
		Transaction transaction = null;
		boolean flag=false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(reg);
			System.out.println("data is saved");
			transaction.commit();
			flag=true;
		}
		catch(HibernateException he){
			transaction.rollback();
			System.out.println("transaction has been rollBack"+he.getMessage());
		}
		finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return flag;
		
	}


	

}
