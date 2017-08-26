package pl.sda.exercise.hibernate.relation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.sda.exercise.hibernate.model.Person;
import pl.sda.exercise.hibernate.model.Skill;

public class ManyToMany {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			List<Person> people = session.createQuery("from Person", Person.class).list();
			System.out.println("People with skills:");
			people.forEach(person -> System.out.println(person + "; " + person.getSkills()));
			List<Skill> skills = session.createQuery("from Skill", Skill.class).list();
			System.out.println("Skills with people:");
			skills.forEach(skill -> System.out.println(skill + "; " + skill.getPeople()));
		}
		finally {
			session.close();
		}
	}

}
