package com.example.fw;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class HibernateHelper // extends HelperBase
{

	private static HibernateHelper hh;

	private HibernateHelper() {
	}

	public static HibernateHelper getHH() {
		if (hh == null)
			hh = new HibernateHelper();
		return hh;
	}

	public SortedListOf<GroupData> getGroups() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
			return new SortedListOf<GroupData>(session.createQuery("from GroupData").list());
		} finally {
			trans.commit();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ContactData> getContacts() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		try {
			return (List<ContactData>)session.createQuery("from ContactData").list();
		} finally {
			trans.commit();
		}
	}
}
