package lv.venta.demo.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.Grade;
import lv.venta.demo.repos.IGradeRepo;
import lv.venta.demo.services.FilteringService;

@Service
public class FilteringServiceImpl implements FilteringService {

	@Autowired
	private IGradeRepo gradeRepo;

	@Override
	public ArrayList<Grade> getAllGradesFromStudentByID(int studentId) {
		ArrayList<Grade> result = gradeRepo.findByStudentIdSt(studentId);
		return result;
	}

	@Override
	public ArrayList<Grade> getAllGradesFromCourseById(int courseId) {
		ArrayList<Grade> result = gradeRepo.findByCourseIdC(courseId);
		return result;
	}

	@Override
	public ArrayList<Grade> getBadGrades() {
		ArrayList<Grade> result = gradeRepo.findByValueLessThan(4);
		return result;
	}

	@Override
	public float getAVGFromCourse(int courseId) {
		float result = gradeRepo.calculateAVGFromCourse(courseId);
		return 0;
	}

}
