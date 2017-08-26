package pl.sda.exercise.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "identity_card") // w tym wybadku bardzo ważna jest ta adnotacja
// inaczej hibernate będzie próbował korzystac z tabeli identitycard, która nie istnieje
public class IdentityCard {

	@Id // tak oznaczaczamy primary key z tabeli w naszej encji
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tak sugerujemy Hibernate, że to baza danych generuje klucze (auto_increment w bazie)
	@Column(name = "id") // tak podajemy nazwę kolumny która ma być zmapowana na pole klasy
	private Integer id; // możemy użyć typu int ale wtedy pozbawiamy się możliwości stosowania wartości null

	@Column(name = "series")
	private String series;

	@Column(name = "number")
	private String number;

	@OneToOne// nazwa relacji
	@JoinColumn(name = "person_id") // klucz obcy wskazujący na krotkę z tabeli person
	private Person person;

	@Override
	public String toString() {
		return "IdentityCard [id=" + id + ", series=" + series + ", number=" + number + "]";
	}

}
