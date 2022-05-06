package lv.venta.demo.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProf;

	@Column(name = "Name")
	private String name;

	@Column(name = "Surname")
	private String surname;

	@Column(name = "Degree")
	private String degree;

	@ManyToMany(mappedBy = "professors")
	private Collection<Course> courses = new ArrayList<Course>();
	// mappedBy norada uz mainigo preteja puse
	// @OneToOne(mappedBy = "professor")
	// @ToString.Exclude
	// private Course course;

	public Professor(String name, String surname, String degree) {
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}
}
