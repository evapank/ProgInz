package lv.venta.demo.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Course {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "IdC")
	@Id
	private int idC;

	@Column(name = "Title")
	private String title;

	@Column(name = "CreditPoints")
	private int creditPoints;

	@OneToOne
	@JoinColumn(name = "IdProf") // colonas nosaukums
	private Professor professor;

	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private ArrayList<Grade> grades;

	public Course(String title, int creditPoints, Professor professor) {
		this.title = title;
		this.creditPoints = creditPoints;
		this.professor = professor;
	}

}
