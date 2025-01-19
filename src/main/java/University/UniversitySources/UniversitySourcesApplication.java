package University.UniversitySources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
=======

@SpringBootApplication
>>>>>>> 7ce0585e977322848117365d1ec414e1483fecee
public class UniversitySourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversitySourcesApplication.class, args);
	}

}
