package vn.techmaster.demojpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;

@SpringBootApplication
public class DemojpaApplication  {


	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);
	}


}
