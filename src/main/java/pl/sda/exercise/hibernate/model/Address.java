package pl.sda.exercise.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id // tak oznaczaczamy primary key z tabeli w naszej encji
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tak sugerujemy Hibernate, że to baza danych generuje klucze (auto_increment w bazie)
	@Column(name = "id") // tak podajemy nazwę kolumny która ma być zmapowana na pole klasy
	private Integer id; // możemy użyć typu int ale wtedy pozbawiamy się możliwości stosowania wartości null

	@Column(name = "city")
	private String city;

	@Column(name = "street")
	private String street;

	@Column(name = "number")
	private Integer number;

	@OneToMany(mappedBy = "address")
	// najprostszy sposób definowania relacji 1:wiele
	// odwrócenie relacji wiele:1
	private Set<Person> people;

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street + ", number=" + number + "]";
	}

}
