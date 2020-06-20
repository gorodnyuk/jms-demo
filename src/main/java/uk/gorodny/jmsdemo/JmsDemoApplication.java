package uk.gorodny.jmsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class JmsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsDemoApplication.class, args);
	}

}
