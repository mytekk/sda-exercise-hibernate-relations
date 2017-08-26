package pl.sda.exercise.hibernate.relation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pl.sda.exercise.hibernate.model.Person;

public class ManyToOne {

	public static void main(String[] args) {
		// najpierw wczytujemy konfigurację i budujemy fabryke sesji
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// mając fabrykę sesji, możemy otworzyć sesję połączeniową z bazą danych
		Session session = sessionFactory.openSession();
		try {
			// za pomocą HQL-a możemy spróbować wszystkie obiekty klasy Person
			// takie przypomnienie, że HQL odwołuje się do encji (obiektów), nie tabel
			List<Person> people = session.createQuery("from Person", Person.class).list();
			// spróbujemy pobrać wszystkie osoby i powiązany z każdą osobą adres
			// za pierwszym razem nie powinno nam się to udać, bo klasa Person nie jest zmapowana
			// odpowiednimi adnotacjami
			System.out.println("People with adresses:");
			people.forEach(person -> System.out.println(person + "; " + person.getAddress()));
		}
		finally {
			session.close();
		}
	}

}
