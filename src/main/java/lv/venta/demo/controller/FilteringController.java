package lv.venta.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lv.venta.demo.models.Grade;
import lv.venta.demo.services.FilteringService;

@Controller
public class FilteringController {
	@Autowired
	private FilteringService filtService;

	@GetMapping("/grades/stud/{id}") // localhost:8080/grades/stud/3
	public String getGradesByStudentId(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("object", filtService.getAllGradesFromStudentByID(id));
		
		
		return "grades-page"; // atvers grade-page.html
	}

	@GetMapping("/grades/course/{id}") // localhost:8080/grades/course/3
	public String getGradesByCourseId(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("object", filtService.getAllGradesFromCourseById(id));
		return "grades-page"; // atvers grade-page.html
	}

	@GetMapping("/grades/bad") // localhost:8080/grades/bad
	public String getGradesByStudentId(Model model) {
		model.addAttribute("object", filtService.getBadGrades());
		return "grades-page"; // atvers grade-page.html
	}
	// TODO izsaukt 4 funkciju no servisa

}
