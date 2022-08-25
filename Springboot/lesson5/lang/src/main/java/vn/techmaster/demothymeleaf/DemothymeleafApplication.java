package vn.techmaster.demothymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemothymeleafApplication {

	public static void main(String[] args) {
		System.setProperty("server.port","8181");
		SpringApplication.run(DemothymeleafApplication.class, args);
	}

}
