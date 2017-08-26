package pl.sda.exercise.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@OneToOne(mappedBy = "person")// określamy które pole z encji IdentityCard przechowuje
	// informację na temat mapowania relacji
	private IdentityCard identityCard;

	@OneToMany // nazwa relacji
	@JoinColumn(name = "person_id") // ważny kod
	// trzeba pamiętać, że w przypadku relacji OneToMany JoinColumn odraca znaczenie
	// tzn. określa kolumnę z kluczem obcym, który wskazuje na naszą krotkę (czyli nasze this)
	// czyli jest to kolumna nie tabeli encji, którą mapujemy ale z przeciwnej strony relacji
	// w razie wątpliwości, można pamiętać, że w ManyToOne i OneToMany oznacza ona kolumnę z tabeli
	// właścicielskiej, a nie zawsze bieżącej
	private Set<BankAccount> bankAccounts;

	@ManyToMany // nazwa relacji
	@JoinTable(// musimy określi tabelę połączeniową i klucze obce
		name = "person_skill",// nazwa tabeli
		joinColumns = @JoinColumn(name = "person_id"),// klucz obcy wskazujący na bieżącą encję
		inverseJoinColumns = @JoinColumn(name = "skill_id")// klucz obcy wskazujący na drugą stronę relacji
	)
	private Set<Skill> skills;

	public Address getAddress() {
		// żeby zmapować relację Many To One potrzebujemy pola adress
		return address;
	}

	public IdentityCard getIdentityCard() {
		// TODO Auto-generated method stub
		return identityCard;
	}

	public Set<BankAccount> getBankAccounts() {
		// TODO Auto-generated method stub
		return bankAccounts;
	}

	public Set<Skill> getSkills() {
		// TODO Auto-generated method stub
		return skills;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
