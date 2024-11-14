package com.P2.CBS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.P2.CBS.repository")
@EntityScan(basePackages = "com.P2.CBS.model")
public class ClinicBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicBookingSystemApplication.class, args);
	}
}


//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//
//@SpringBootApplication
//@ComponentScan("com.P2.CBS")  // Specify the package explicitly if needed
//
//public class ClinicBookingSystemApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ClinicBookingSystemApplication.class, args);
//	}
//}



//package com.P2.CBS;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.beans.factory.annotation.Autowired;
//import javax.sql.DataSource;
//import java.sql.Connection;
//
//@SpringBootApplication
//public class com.P2.CBS.ClinicBookingSystemApplication implements CommandLineRunner {
//
//	@Autowired
//	private DataSource dataSource;
//
//	public static void main(String[] args) {
//		SpringApplication.run(com.P2.CBS.ClinicBookingSystemApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		try (Connection connection = dataSource.getConnection()) {
//			System.out.println("Connected to the database successfully!");
//		} catch (Exception e) {
//			System.err.println("Failed to connect to the database: " + e.getMessage());
//		}
//	}
//}
