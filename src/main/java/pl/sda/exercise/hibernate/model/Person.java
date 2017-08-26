package pl.sda.exercise.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;

@Entity
@Table(name = "person")
public class Person {

	@Id // tak oznaczaczamy primary key z tabeli w naszej encji
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tak sugerujemy Hibernate, że to baza danych generuje klucze (auto_increment w bazie)
	@Column(name = "id") // tak podajemy nazwę kolumny która ma być zmapowana na pole klasy
	private Integer id; // możemy użyć typu int ale wtedy pozbawiamy się możliwości stosowania wartości null

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToOne// adnotacja wskazująca rodzaj relacji
	@JoinColumn(name = "address_id") // wskazujemy, które pole w tabeli person jest kluczem obcym do
	// tabeli address
	// żeby móc korzystać z tego pola, musimy zmapować także tę encję
	private Address address;

	public Address getAddress() {
		// żeby zmapować relację Many To One potrzebujemy pola adress
		return address;
	}

	public IdentityCard getIdentityCard() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<BankAccount> getBankAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Skill> getSkills() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
