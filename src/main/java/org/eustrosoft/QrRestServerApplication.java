package org.eustrosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.eustrosoft"})
public class QrRestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrRestServerApplication.class, args);
	}

}
