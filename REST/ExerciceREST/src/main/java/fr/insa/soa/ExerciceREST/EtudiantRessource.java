package fr.insa.soa.ExerciceREST;

import fr.insa.soa.ExerciceREST.Etudiant;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("etudiant")
public class EtudiantRessource {
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@Context UriInfo uriInfo) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("M");
		etudiant.setPrenom("M");
		etudiant.setId(01);
		etudiant.addLink(getUriforSelf(uriInfo, etudiant), "self", "GET");
		etudiant.addLink (getUriforStage (uriInfo), "Stage", "GET");
		return etudiant;
		
	}

	private String getUriforStage (UriInfo uriInfo) {
		String url=uriInfo.getBaseUriBuilder() // http://localhost:8080/ExerciceREST/webapi
			.path(StageRessource.class) // /stage
			.build()
			.toString();
		return url;
	}

	private String getUriforSelf (UriInfo uriInfo, Etudiant etudiant) {
		String url=uriInfo.getBaseUriBuilder() // http://localhost:8080/ExerciceREST/webapi
				.path(EtudiantRessource.class) // /etudiant
				.path(Long.toString(etudiant.getId())) // /01
				.build()
				.toString();
		return url;
	}

	
	@GET
	@Path("/{idEtudiant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiantById(@PathParam("idEtudiant") int id) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("C");
		etudiant.setPrenom("T");
		return etudiant;
	}
	
	@POST
	@Path("/{idEtudiant}")
	public void addEtudiant(Etudiant etudNew) {
		System.out.println("Ajout de l'étudiant " + etudNew.getNom() + " réussie !");
		System.out.println("Son binôme est " + etudNew.getBinome().getPrenom() + " " + etudNew.getBinome().getNom());
	}
	
}
