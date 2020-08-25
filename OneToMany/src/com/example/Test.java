package com.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction txt = session.beginTransaction();

		Certificate c1 = new Certificate();
		c1.setId(1);
		c1.setName("Bca");
		c1.setYear("2009");

		Certificate c2 = new Certificate();
		c2.setId(2);
		c2.setName("Mca");
		c2.setYear("2012");

		Set<Certificate> certificates = new HashSet<>();
		certificates.add(c1);
		certificates.add(c2);

		Student s1 = new Student();
		s1.setRoll(123);
		s1.setName("Deep Singh");
		s1.setCertificates(certificates);

		session.persist(s1);

		txt.commit();
		System.out.println("success");

		/*
		 * Student std = session.get(Student.class, 123);
		 * System.out.println(std.getName()); Set<Certificate> ss =
		 * std.getCertificates(); Iterator<Certificate> it = ss.iterator();
		 * while (it.hasNext()) { Certificate c = it.next();
		 * System.out.println(c.getName() + "\t" + c.getYear()); }
		 */
	}
}
