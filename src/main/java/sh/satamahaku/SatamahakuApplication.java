package sh.satamahaku;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.LoggerFactory;

import java.util.List;

import org.slf4j.Logger;

import sh.satamahaku.domain.Harbour;
import sh.satamahaku.domain.HarbourRepository;
import sh.satamahaku.domain.User;
import sh.satamahaku.domain.UserRepository;

@SpringBootApplication
public class SatamahakuApplication {
	private static final Logger log = LoggerFactory.getLogger(SatamahakuApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SatamahakuApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(HarbourRepository harbourRepository, UserRepository userRepository){
		return(args) ->{
			log.info("Demo data");
			Harbour harbour1 = new Harbour("Hanko vierasvenesatama, Itäsatama", " 59°49,2', 22°58,3'", 80, "Olet lämpimästi tervetullut Hankoon uudistettuun vierasvenesatamaamme.");
			Harbour harbour2 = new Harbour("Kasnäs", "59°55,3', 22°24,6'", 100, "Tervetuloa rantautumaan Kasnäsin vierasvenesatamaan.");

			User user1 = new User("idaerika", "Ida", "Tolvanen", "i.tolvanen@gmail.com", null);
			User user2 = new User("tuomasaarre", "Tuomas", "Simoinen", "t.simoinen@gmail.com", null);



			log.info("fetch");
			harbourRepository.save(harbour1);
			harbourRepository.save(harbour2);
			userRepository.save(user1);
			userRepository.save(user2);
		};
	}

}
