package fr. insa. soap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import fr.insa.soap.wsdltojava.AnalyserChaineWS;
import fr.insa.soap.wsdltojava.Analyzer;

public class ClientOfAnalyzer {

	public static void main(String [] args) throws MalformedURLException {
		// L'adresse service Web
		final String adresse="http://localhost:8089/analyzer";
		
		//Création de l'URL
		final URL url=URI.create(adresse).toURL();
		
		// Instanciation l'image du service
		final Analyzer service = new Analyzer(url);
		
		//Création du proxy (en utilisant le port Type) pour l'appel du service
		final AnalyserChaineWS port = service.getPort(AnalyserChaineWS.class);
		
		String chaine ="Thomas est vraiment gentil malgré les démons alentours";
		
		//Appel de la méthode compare via le port
		System.out.println("La taille de la chaine "+chaine+" est "+port.compare(chaine)) ;
	}

}
