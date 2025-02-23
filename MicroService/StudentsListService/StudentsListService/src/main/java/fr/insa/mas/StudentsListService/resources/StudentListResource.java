package fr.insa.mas.StudentsListService.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.StudentsListService.model.Evaluation;
import fr.insa.mas.StudentsListService.model.Student;
import fr.insa.mas.StudentsListService.model.StudentIDList;
import fr.insa.mas.StudentsListService.model.StudentInfos;

@RestController
@RequestMapping("/students")
public class StudentListResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("ids/{idSpeciality}")
	public StudentIDList getIDStudents(@PathVariable("idSpeciality") String speciality) {
		
		StudentIDList studentsID = new StudentIDList();
		studentsID.addStudentToList(0);
		studentsID.addStudentToList(1);
		studentsID.addStudentToList(2);
		studentsID.addStudentToList(3);
		
		return studentsID;
	}
	
	@GetMapping("/all/{idSpecialty}")
	public List<Student> getStudents(@PathVariable("idSpecialty") String speciality) {
		
		//Simulate the db using a list of integers
		StudentIDList students = new StudentIDList();
		students.addStudentToList(0);
		students.addStudentToList(1);
		students.addStudentToList(2);
		students.addStudentToList(3);
		
		//Instanciate RestTemplate for Rest calls
//		RestTemplate restTemplate = new RestTemplate(); 
		// On supprime cette instanciation qui n'est plus nécessaire dans la partie 3 avec Bean et l'autowired.
		int i = 0;
		List<Student> listStudents = new ArrayList<Student>();
		
		while (i < students.getStudentList().size()) {
			//Call the MS StudentInfoService to get student's information.
//			StudentInfos etudInfos = restTemplate.getForObject("http://localhost:8081/student/"+ i, StudentInfos.class);
			// On modifie l'appel avec l'url directe du ms tel que référencé par Eureka 
			StudentInfos etudInfos = restTemplate.getForObject("http://StudentInfoService/student/"+ i, StudentInfos.class);
			
			//Call the MS StudentEvalService to get student's evaluation
			//The result is deserialized into Evaluation java object
//			Evaluation eval = restTemplate.getForObject("http://localhost:8082/evaluation/"+ i, Evaluation.class);
			// On modifie l'appel avec l'url directe du ms tel que référencé par Eureka 
			Evaluation eval = restTemplate.getForObject("http://StudentEvalService/evaluation/"+ i, Evaluation.class);

			
			//Instanciate a student with his id, firt and last Name, average and store it in the list
			listStudents.add(new Student(i, etudInfos.getFirstName(), etudInfos.getLastName(), eval.getAverage()));
			
			i++;
		}
		return listStudents;
	}
	

}
