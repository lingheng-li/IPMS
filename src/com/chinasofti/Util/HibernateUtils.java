package com.chinasofti.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static{
		//1.����Configuration�������õ���hibernate.cfg.xml
//				Configuration config = new Configuration().configure();
			ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
				//2.����������Ϣ����SessionFactory����
			    sf =(SessionFactory)ac.getBean("sessionFactory");
	}
	//���session=�����ȫ�µ�session
	public static Session openSession(){
		//���Session
		Session session = sf.openSession();
		return session;
	}
	
	//���session=��������̰߳󶨵��߳�
	public static Session getCurrentSession(){
		//���Session
		Session session = sf.getCurrentSession();
		return session;
	}
}
