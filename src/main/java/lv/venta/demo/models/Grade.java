package lv.venta.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Grade {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "IdGr")
	@Id
	private int idGr;

	@Column(name = "Value")
	private int value;

	@ManyToOne
	@JoinColumn(name = "IdSt")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "IdC")
	private Course course;

	public Grade(int value, Student student, Course course) {
		this.value = value;
		this.student = student;
		this.course = course;
	}

}
