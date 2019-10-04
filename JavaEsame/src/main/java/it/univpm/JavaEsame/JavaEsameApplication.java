package it.univpm.JavaEsame;

import java.io.IOException;
import java.net.URL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.univpm.JavaEsame.Data.ArrayData;
import it.univpm.JavaEsame.Data.Buffer;
import it.univpm.JavaEsame.Data.Parsing;

@SpringBootApplication
public class JavaEsameApplication {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://data.europa.eu/euodp/data/api/3/action/package_show?id=tkbI4e1nPSh1HAhvoIhqQ");
		Buffer buff = new Buffer(url);
		ArrayData data = new ArrayData();
		Parsing parser = new Parsing(buff.file());
		System.out.println(data.getData());
		
		
		
		
		
		
		SpringApplication.run(JavaEsameApplication.class, args);
	}

}
