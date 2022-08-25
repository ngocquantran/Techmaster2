package vn.techmaster.demothymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemothymeleafApplication {


	public static void main(String[] args) {
		System.getProperties().put( "server.port", 9090 );
		SpringApplication.run(DemothymeleafApplication.class, args);
	}

}
