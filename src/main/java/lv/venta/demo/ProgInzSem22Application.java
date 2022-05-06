package lv.venta.demo;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.demo.models.Course;
import lv.venta.demo.models.Grade;
import lv.venta.demo.models.Professor;
import lv.venta.demo.models.Student;
import lv.venta.demo.repos.ICourseRepo;
import lv.venta.demo.repos.IGradeRepo;
import lv.venta.demo.repos.IProfessorRepo;
import lv.venta.demo.repos.IStudentRepo;

@SpringBootApplication
public class ProgInzSem22Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSem22Application.class, args);
	}

	//@Bean
	public CommandLineRunner runner(IProfessorRepo profRepo, IStudentRepo studRepo, ICourseRepo courseRepo,
			IGradeRepo gradeRepo) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Professor prof1 = new Professor("Karina", "Skirmante", "Mg.sc.comp");
				Professor prof2 = new Professor("Raita", "Rollande", "Dr.ing");
				profRepo.save(prof1);
				profRepo.save(prof2);

				Student stud1 = new Student("Janis", "Berzins");
				Student stud2 = new Student("Baiba", "Jauka");
				studRepo.save(stud1);
				studRepo.save(stud2);

				Course course1 = new Course("JAVA", 4, new ArrayList<>(Arrays.asList(prof1)));
				Course course2 = new Course("ProgInz", 4, new ArrayList<>(Arrays.asList(prof1, prof2)));
				courseRepo.save(course1);
				courseRepo.save(course2);

				prof1.addCourse(course1);
				prof1.addCourse(course2);
				profRepo.save(prof1);
				prof2.addCourse(course2);
				profRepo.save(prof2);

				gradeRepo.save(new Grade(10, stud1, course1));
				gradeRepo.save(new Grade(3, stud2, course2));
				gradeRepo.save(new Grade(5, stud1, course2));
				gradeRepo.save(new Grade(7, stud2, course1));

			}
		};
	}

}
