package lv.venta.demo.services;

import java.util.ArrayList;

import lv.venta.demo.models.Grade;
import lv.venta.demo.models.Student;

public interface FilteringService {

	// atrast konkreta studenta visas atzimes
	public abstract ArrayList<Grade> getAllGradesFromStudentByID(int studentId);

	// atrast visas atzimes konkreta kursa
	public abstract ArrayList<Grade> getAllGradesFromCourseById(int courseId);

	// TODO atrast konkreta studenta atzimes pec vina varda

	// atrast visas nesekmigas atzimes un so atzimju studentus
	public abstract ArrayList<Grade> getBadGrades();
	
	//atrast videjo atzimi konkreta kursa
	public abstract float getAVGFromCourse(int courseId);
	
	//TODO atrast videjo atzimi konkretam studentam
}
