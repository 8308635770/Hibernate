package com.luv2code.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		try {
			Student student1 = new Student("srt1", "tapade1", "stapade1@gmail.com");
			Student student2 = new Student("srt2", "tapade2", "stapade2@gmail.com");
			Student student3 = new Student("srt3", "tapade3", "stapade3@gmail.com");

			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);

			session.getTransaction().commit();
			
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			Student s= session.get(Student.class,student1.getId());
			
			System.out.println("Output:"+s.getFirstName()+" "+s.getLastName());
			
			System.out.println("Done...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
