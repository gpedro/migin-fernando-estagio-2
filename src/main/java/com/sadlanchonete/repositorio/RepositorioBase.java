package com.sadlanchonete.repositorio;

import java.util.List;

import org.hibernate.Session;

import com.sadlanchonete.dao.utils.HibernateUtil;

public abstract class RepositorioBase<T> implements IRepositorioBase<T> {

	private Class<T> persistentClass;

	public RepositorioBase(Class<T> pclass) {
		this.persistentClass = pclass;
		getSession();
	}

	private Session session;

	public Session getSession() {
		if (session == null) {
			session = HibernateUtil.getSessionFactory().openSession();
		}

		return session;
	}

	public void add(T obj) {
		try {
			session.beginTransaction();
			session.save(obj);
			session.getTransaction().commit();
		} catch (Exception erro) {
			erro.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public void remove(T obj) {
		try {
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
		} catch (Exception erro) {
			erro.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(T obj) {
		try {
			session.beginTransaction();
			session.update(obj);
			session.getTransaction().commit();
		} catch (Exception erro) {
			erro.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	public T getById(int id) {
		@SuppressWarnings("unchecked")
		T t = (T) session.get(persistentClass, id);
		return t;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return session.createCriteria(persistentClass).list();
	}

}
