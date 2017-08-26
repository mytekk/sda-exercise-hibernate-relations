package pl.sda.exercise.hibernate.relation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.sda.exercise.hibernate.model.Person;

public class ManyToOne {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			List<Person> people = session.createQuery("from Person", Person.class).list();
			System.out.println("People with adresses:");
			people.forEach(person -> System.out.println(person + "; " + person.getAddress()));
		}
		finally {
			session.close();
		}
	}

}
