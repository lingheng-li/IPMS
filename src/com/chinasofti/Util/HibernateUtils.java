package com.chinasofti.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtils {
	private static SessionFactory sf;
	
	static{
		//1.创建Configuration对象挑用调用hibernate.cfg.xml
//				Configuration config = new Configuration().configure();
			ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
				//2.根据配置信息创建SessionFactory对象
			    sf =(SessionFactory)ac.getBean("sessionFactory");
	}
	//获得session=》获得全新的session
	public static Session openSession(){
		//获得Session
		Session session = sf.openSession();
		return session;
	}
	
	//获得session=》获得与线程绑定的线程
	public static Session getCurrentSession(){
		//获得Session
		Session session = sf.getCurrentSession();
		return session;
	}
}
