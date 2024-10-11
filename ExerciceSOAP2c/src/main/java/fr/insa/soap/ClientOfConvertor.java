package fr. insa. soap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import fr.insa.soap.wsdltojava.NumberConversionSoapType;
import fr.insa.soap.wsdltojava.NumberConversion;

public class ClientOfConvertor {

	public static void main(String [] args) throws MalformedURLException {
		// L'adresse service Web
		final String adresse="https://www.dataaccess.com/webservicesserver/numberconversion.wso";
		
		//Création de l'URL
		final URL url=URI.create(adresse).toURL();
		
		// Instanciation l'image du service
		final NumberConversion service = new NumberConversion(url);
		
		//Création du proxy (en utilisant le port Type) pour l'appel du service
		final NumberConversionSoapType port = service.getPort(NumberConversionSoapType.class);
		
		BigInteger num = new BigInteger("712");
		BigDecimal numd = new BigDecimal("712");

		
		//Appel de la méthode compare via le port
		System.out.println("Le nombre "+num+" s'écrit "+port.numberToWords(num)) ;
		System.out.println("La valeur "+numd+"$ s'écrit "+port.numberToDollars(numd)) ;
	}

}