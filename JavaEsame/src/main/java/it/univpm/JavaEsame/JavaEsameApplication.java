package it.univpm.JavaEsame;

import java.io.IOException;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.JavaEsame.Computing.Stringhe;
import it.univpm.JavaEsame.Data.Buffer;
import it.univpm.JavaEsame.Data.Parsing;

@SpringBootApplication
public class JavaEsameApplication {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://data.europa.eu/euodp/data/api/3/action/package_show?id=tkbI4e1nPSh1HAhvoIhqQ");
		Buffer buff = new Buffer(url);
		Parsing parser = new Parsing();
		parser.parser(buff.file());
		/*Computing media = new Computing("2017");
		System.out.println("Media: " + media.Avg() + " massimo: "+ media.Max() + " minimo: "+ media.Min());
		*/
		//Stringhe string = new Stringhe();
	
	
		SpringApplication.run(JavaEsameApplication.class, args);
	}

}
