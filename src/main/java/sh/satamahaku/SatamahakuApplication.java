package sh.satamahaku;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import org.hibernate.mapping.Array;
import org.slf4j.Logger;

import sh.satamahaku.domain.Harbour;
import sh.satamahaku.domain.HarbourRepository;
import sh.satamahaku.domain.HarbourType;
import sh.satamahaku.domain.HarbourTypeRepository;
import sh.satamahaku.domain.Service;
import sh.satamahaku.domain.ServiceRepository;
import sh.satamahaku.domain.User;
import sh.satamahaku.domain.UserRepository;
import sh.satamahaku.domain.UserType;
import sh.satamahaku.domain.UserTypeRepository;

@SpringBootApplication
public class SatamahakuApplication {
	private static final Logger log = LoggerFactory.getLogger(SatamahakuApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SatamahakuApplication.class, args);
	}

	@Bean
	public CommandLineRunner demodata(HarbourRepository harbourRepository, UserRepository userRepository, HarbourTypeRepository harbourTypeRepository, ServiceRepository serviceRepository, UserTypeRepository userTypeRepository){
		return(args) ->{
			log.info("Demo data");

			//user type
			UserType userType1 = new UserType("ADMIN");
			UserType userType2 = new UserType("USER");

			userTypeRepository.save(userType1);
			userTypeRepository.save(userType2);

			// demo users
			User user1 = new User("idaerika", "Ida", "Tolvanen", "i.tolvanen@gmail.com", null);
			User user2 = new User("tuomasaarre", "Tuomas", "Simoinen", "t.simoinen@gmail.com", null);

			
			
			// Services for harbours
			Service service1 = new Service("Wc","Wc-tilat monipuolisesti");
			Service service2 = new Service("Tankkaus","Diesel sekä Bensiinin tankkaus satamassa");
			Service service3 = new Service("Sauna","Naisille ja miehille omat saunatilat");

			// save services
			serviceRepository.save(service1);
			serviceRepository.save(service2);
			serviceRepository.save(service3);

			// Harbour types
			HarbourType harbourType1 = new HarbourType("Palvelusatama");
			HarbourType harbourType2 = new HarbourType("Luonnonsatama");

			//saving harbour types
			harbourTypeRepository.save(harbourType1);
			harbourTypeRepository.save(harbourType2);

			// New harbours
			Harbour harbour1 = new Harbour("Hanko vierasvenesatama, Itäsatama",
									" 59°49,2', 22°58,3'",
									80, 
									"Olet lämpimästi tervetullut Hankoon uudistettuun vierasvenesatamaamme.", 
									harbourType1,
									null);
			Harbour harbour2 = new Harbour("Kasnäs", "59°55,3', 22°24,6'", 100, "Tervetuloa rantautumaan Kasnäsin vierasvenesatamaan.", harbourType1, null);
			

			// setting harbour types for harbours
			// harbour1.setHarbourType(harbourType1);
			// harbour2.setHarbourType(harbourType2);

			


			// saving harbours
			harbourRepository.save(harbour1);
			harbourRepository.save(harbour2);

			log.info("fetch");

			service1.addHarbours(harbour2);
			service2.addHarbours(harbour2);
			service3.addHarbours(harbour2);

			serviceRepository.save(service1);
			serviceRepository.save(service2);
			serviceRepository.save(service3);

			// save users
			userRepository.save(user1);
			userRepository.save(user2);

			user1.addFavoriteHarbour(harbour2);


			user1.setUserType(userType2);

			userRepository.save(user1);
		};
	}

}
