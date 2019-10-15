package it.univpm.JavaEsame;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.JavaEsame.Exception.ExceptionsExtend;
import it.univpm.JavaEsame.ManagingData.Buffer;
import it.univpm.JavaEsame.ManagingData.Parsing;

@SpringBootApplication
public class JavaEsameApplication {

	public static void main(String[] args) throws  IOException 
		
	 {
		
		URL url = new URL("http://data.europa.eu/euodp/data/api/3/action/package_show?id=tkbI4e1nPSh1HAhvoIhqQ");
		Buffer buff = new Buffer(url);
		Parsing parser = new Parsing();
		parser.parser(buff.file());
		SpringApplication.run(JavaEsameApplication.class, args);
	
	}

}
