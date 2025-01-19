package University.UniversitySources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class UniversitySourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversitySourcesApplication.class, args);
	}

}
