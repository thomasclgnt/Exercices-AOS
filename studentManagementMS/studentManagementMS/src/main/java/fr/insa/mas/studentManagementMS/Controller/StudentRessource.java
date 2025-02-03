package fr.insa.mas.studentManagementMS.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.studentManagementMS.model.Student;

@RestController
public class StudentRessource {
	
	private List<Student> students = new ArrayList<>();
	
	public StudentRessource() {
		students.add(new Student(1, "Rosa", "Parks"));
		students.add(new Student(2, "Nelson", "Mandela"));
	}

	@GetMapping("/students/old")
	public int studentNumber() {
		
		return 200;
	}
	
	@GetMapping(value="/students/old/{id}")
	public Student infosStudent(@PathVariable int id) {
		Student student = new Student (id, "Rosa", "Parks");
		return student;
	}
	
	@GetMapping(value="/students/old/xml/{id}", produces=MediaType.APPLICATION_XML_VALUE)
	public Student infosStudentxml(@PathVariable int id) {
		Student student = new Student (id, "Rosa", "Parks");
		return student;
	}
	
	@GetMapping(value="/students")
	public List<Student> getAllStudents() {
		return students;
	}
	
	@GetMapping(value="/students/size")
	public int getStudentsNumber() {
		return students.size();
	}
	
	@GetMapping(value="/students/get/{id}")
	public Student getStudentById(@PathVariable int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}
	
	@PostMapping(value="/students/new/{prenom}/{nom}")
	public Student  addStudent(@PathVariable String prenom, @PathVariable String nom) {
		int id = students.size() +1;
		Student student = new Student(id, nom, prenom);
		students.add(student);
		return student;
	}
	
	@PutMapping(value="/students/update/nom/{id}/{new_nom}")
	public Student updateStudentNom(@PathVariable int id, @PathVariable String new_nom) {
		Student student = getStudentById(id);
		student.setLastName(new_nom);
		return student;
	}
	
	@PutMapping(value="/students/update/prenom/{id}/{new_prenom}")
	public Student updateStudentPrenom(@PathVariable int id, @PathVariable String new_prenom) {
		Student student = getStudentById(id);
		student.setFirstName(new_prenom);
		return student;
	}
	
}
