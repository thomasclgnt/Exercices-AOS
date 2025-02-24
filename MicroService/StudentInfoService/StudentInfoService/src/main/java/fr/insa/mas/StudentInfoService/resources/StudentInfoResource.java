package fr.insa.mas.StudentInfoService.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.StudentInfoService.model.StudentInfos;

@RestController
@RequestMapping("/student")
public class StudentInfoResource {
	
	@Value("${db.uri}")
	private String dbUri;
	
	@Value("${db.name}")
	private String dbName;
	
	@Value("${db.login}")
	private String dbLogin;
	
	@Value("${db.pwd}")
	private String dbPwd;

	@GetMapping("/dbUri")
	public String getDbUri() {
		return dbUri;
	}

	public void setDbUri(String dbUri) {
		this.dbUri = dbUri;
	}

	@GetMapping("/dbName")
	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	@GetMapping("/dbLog")
	public String getDbLogin() {
		return dbLogin;
	}

	public void setDbLogin(String dbLogin) {
		this.dbLogin = dbLogin;
	}

	@GetMapping("/dbPwd")
	public String getDbPwd() {
		return dbPwd;
	}

	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}
	
	
	@GetMapping("/{idStudent}")
	public StudentInfos getInfoEtudiant(@PathVariable("idStudent") int id) {
		
		//Simulate the DB with a list
		List<StudentInfos> etudInfos=Arrays.asList(
				new StudentInfos(0, "Godart", "Noemie", "12/12/1992"),
				new StudentInfos(1, "Perrin", "Ania", "10/02/1993"),
				new StudentInfos(2, "Azi", "Sana", "22/05/1992"),
				new StudentInfos(3, "Yala", "Nelia", "12/06/1994")
				);
		
		System.out.println("Called...");
		System.out.println("Connection à la BDD : " + this.getDbName() + " à l'URI : " + this.getDbUri());
		
		//Get the student that corresponds to the id
		return etudInfos.get(id);
	}

}
