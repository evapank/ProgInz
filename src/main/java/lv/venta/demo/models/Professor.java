package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Professor {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "IdProf")
	@Id
	private int idProf;

	@Column(name = "Name")
	private String name;

	@Column(name = "Surname")
	private String surname;

	@Column(name = "Degree")
	private String degree;

	// mappedBy norada uz mainigo preteja puse
	@OneToOne(mappedBy = "professor")
	@ToString.Exclude
	private Course course;

	public Professor(String name, String surname, String degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}

}
