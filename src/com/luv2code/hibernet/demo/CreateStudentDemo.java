package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Student student = new Student("srt", "tapade", "stapade@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Done...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
