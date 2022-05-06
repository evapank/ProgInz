package lv.venta.demo.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.demo.models.Grade;
import lv.venta.demo.models.Student;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {
	// tiks genereta no DATA JPA, ir svarigs funkcijas nosaukums
	public abstract ArrayList<Grade> findByStudentId_St(int studentId);

	// tiks genereta no DATA JPA, ir svarigs funkcijas nosaukums
	public abstract ArrayList<Grade> findByCourseId_C(int courseId);

	// tiks genereta no DATA JPA, ir svarigs funkcijas nosaukums
	public abstract ArrayList<Grade> findByValueLessThan(int i);

	// pasu veidots SQL vaicajums, nav svarigs funkcijas nosaukums
	@Query(value = "select avg(value) from grade where idc=?1;", nativeQuery = true)
	public abstract float calculateAVGFromCourse(int courseId);

}
