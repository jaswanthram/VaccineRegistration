package com.ram.project.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ram.project.models.MemberEntity;

@Component
public class AddMemberDaoImpl implements AddMemberDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	public AddMemberDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("session factory object is created");
	}

	
	@Override
	public boolean SaveMemberDetails(MemberEntity entity,String mail) {
		Session session=null;
		Transaction transaction=null;
		System.out.println(mail);
		
		try {
			session = sessionFactory.openSession();
			
			
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			
			return true;
			
		}catch(Exception e) {
			System.out.println("Exception occured");
			if(transaction != null) {
				transaction.rollback();
			}
		}finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
		return false;
	}


	@Override
	public List<MemberEntity> getDataFromDb(String mail) {
		
		String hql="FROM MemberEntity m WHERE m.mailAddress = '"+mail+"' ";
		Session session=null;
		
		try {
			session=sessionFactory.openSession();
			
			Query query = session.createQuery(hql);
			List list = query.getResultList();
			
			return list;
		}finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
	}


	@Override
	public List<MemberEntity> countTheMembers(String mail) {
		String hqlQuery="FROM MemberEntity m WHERE m.mailAddress = '"+mail+"' ";
		Session session=null;

		try {
			session=sessionFactory.openSession();
			
			Query query = session.createQuery(hqlQuery);
			List members = query.getResultList();
			
			return members;
		}finally {
			if(session != null) {
				session.close();
				System.out.println("session closed");
			}
		}
	}


	@Override
	public MemberEntity getMember(int id) {
		Session session=null;
		try {
			session = sessionFactory.openSession();
			MemberEntity entity = session.get(MemberEntity.class, id);
			System.out.println(entity);
			return entity;
		} finally {
			if(session != null) {
				System.out.println("session closed");
			}
		}
	}


	public boolean updateMember(MemberEntity entity) {
		Session session=null;
		boolean flag=false;
		try {
			session=sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			System.out.println("Data is updated in data base");
			flag = true;
		}finally {
			if(session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		return flag;
		
	}


	public boolean deleteMemberEntity(int id) {
		Session session=null;
		try {
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			MemberEntity entity = session.get(MemberEntity.class, id);
			session.delete(entity);
			transaction.commit();
			return true;
		} finally {
			if(session != null) {
				session.close();
				System.out.println("session is closed");
			}
		}
		
	}

}
