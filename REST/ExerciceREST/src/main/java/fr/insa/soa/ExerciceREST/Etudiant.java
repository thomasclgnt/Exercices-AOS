package fr.insa.soa.ExerciceREST;

import java.util.ArrayList;

public class Etudiant {
	private String nom;
	private String prenom;
	private Binome binome;
	private Stage stage;
	private int id;
	private ArrayList<Link> links = new ArrayList<Link>();
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Binome getBinome() {
		return binome;
	}
	public void setBinome(Binome binome) {
		this.binome = binome;
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void addLink(String uri, String rel, String methode) {
		Link newLink = new Link() ;
		newLink.setUri(uri);
		newLink.setRel(rel);
		newLink.setMethode(methode);
		links.add(newLink);
	}
	
	public ArrayList<Link> getLinks(){
		return links ;
	}
}
