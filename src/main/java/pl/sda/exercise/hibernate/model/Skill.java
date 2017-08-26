package pl.sda.exercise.hibernate.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {

	@Id // tak oznaczaczamy primary key z tabeli w naszej encji
	@GeneratedValue(strategy = GenerationType.IDENTITY) // tak sugerujemy Hibernate, że to baza danych generuje klucze (auto_increment w bazie)
	@Column(name = "id") // tak podajemy nazwę kolumny która ma być zmapowana na pole klasy
	private Integer id; // możemy użyć typu int ale wtedy pozbawiamy się możliwości stosowania wartości null

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private String level;

	@ManyToMany(mappedBy = "skills")
	private Set<Person> people;

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", level=" + level + "]";
	}

	public Set<Person> getPeople() {
		// TODO Auto-generated method stub
		return people;
	}

}
