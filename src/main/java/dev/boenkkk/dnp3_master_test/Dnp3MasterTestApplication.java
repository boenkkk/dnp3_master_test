package dev.boenkkk.dnp3_master_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Dnp3MasterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Dnp3MasterTestApplication.class, args);

		MasterRun.main(args);
	}

}
