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
			User user1 = new User("testi", "testi", "Tolvanen", "t.tolvanen@gmail.com", "$2a$10$yvYQIl2nglmwmMiHlf2s/uPuQgkY1gdz/so8/yBa80q2a2RbuT.EW");
			User user2 = new User("tuomasaarre", "Tuomas", "Simoinen", "t.simoinen@gmail.com", "$2a$10$0Exj6qq9YFPALuwTk58WceDVBpuuOgdxjjI7pENtXz184O1YMHgxm");
			User user3 = new User("Admin", "ad", "min", "admin@admin.com", "$2a$10$5DiF2ZLwX7s4je23z8ZUNut6Wzd0S81i5t5FaIKQG/2mIGRpKcpM6");
			
			
			// Services for harbours
			Service wc = new Service("Wc");
			Service suihku = new Service("Suihku");
			Service polttoaine = new Service("Polttoaine");
			Service sauna = new Service("Sauna");
			Service grillipaikka = new Service("Grillipaikka");
			Service juomavesi = new Service("Juomavesi");
			Service kahvila = new Service("Kahvila");
			Service leikkipaikka = new Service("Leikkipaikka");
			Service luontopolku = new Service("Luontopolku");
			Service majoitus = new Service("Majoitus");
			Service nahtavaa = new Service("Nähtävää");
			Service uimaranta = new Service("Uimaranta");
			Service yhteysalus = new Service("Yhteysalus");
			Service alko = new Service("Alko");
			Service ruokakauppa = new Service("Ruokakauppa");
			Service ravintola = new Service("Ravintola");
			Service pesutupa = new Service("Pesutupa");
			Service septi = new Service("Septityhjennys");
			Service veneramppi = new Service("Veneramppi");
			Service apteekki = new Service("Apteekki");
			Service maasähkö = new Service("Maasähkö");

			// save services
			serviceRepository.save(wc);
			serviceRepository.save(polttoaine);
			serviceRepository.save(sauna);
			serviceRepository.save(grillipaikka);
			serviceRepository.save(juomavesi);
			serviceRepository.save(kahvila);
			serviceRepository.save(leikkipaikka);
			serviceRepository.save(luontopolku);
			serviceRepository.save(majoitus);
			serviceRepository.save(nahtavaa);
			serviceRepository.save(uimaranta);
			serviceRepository.save(yhteysalus);
			serviceRepository.save(alko);
			serviceRepository.save(ruokakauppa);
			serviceRepository.save(ravintola);
			serviceRepository.save(pesutupa);
			serviceRepository.save(septi);
			serviceRepository.save(suihku);
			serviceRepository.save(veneramppi);
			serviceRepository.save(apteekki);
			serviceRepository.save(maasähkö);


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
									"Olet lämpimästi tervetullut Hankoon vierasvenesatamaamme. Jo laituriin saapuessasi sinua vastaanottaa osaava henkilökunta, joka haluaa tarjota sinulle parasta mahdollista palvelua. Kaipaatko lämmintä suihkua, uunituoretta leipää tai kenties varaosia? Me olemme täällä sinua varten, niin maakravuille kuin kokeneille merikarhuillekin.\n" + //
																				"\n" + //
																				"Suomen suurin vierasvenesatama, Hangon Itäsatama, on Itämeren helmi. Toivotamme teidät lämpimästi tervetulleeksi meidän satamaamme tänä kesänä kokemaan täällä puhaltelevat raikkaat tuulet!", 
									harbourType1,
									null);
			harbourRepository.save(harbour1);

			Harbour harbour2 = new Harbour("Kasnäs", "59°55,3', 22°24,6'", 100, "Tervetuloa rantautumaan Kasnäsin vierasvenesatamaan.", harbourType1, null);
			
			harbourRepository.save(harbour2);

			Harbour jussarö = new Harbour("Jussarö", "59°49,6‘N 23°34,1‘E", 49, "Tie kaivosalueelle kulkee lohduttoman näköisten kerrostalojen vieritse, vanhat kaivosrakennukset ovat kuitenkin ihan asiallisia. Tien päästä pitäisi lähteä polku näkötornille. En löydä sitä ja palaan Kaupunkisota-alueelle – armeija käytti hylättyä asuinaluetta harjoituksiinsa 1970-luvulta alkaen. Vierassatama Jussaröön avattiin vuonna 2005. Kävijämäärät nousivat viitisen vuotta, ja olivat parhaimmillaan vuonna 2010 jopa 14 000. Metsähallitus pyrkii yhä lisäämään kansallispuiston kävijämäärää, ja alueen palveluja kehitetäänkin EU:n tuella vuoteen 2013 asti.", harbourType1, null);

			harbourRepository.save(jussarö);


			Harbour HögsåraKejsarhamnen = new Harbour("Högsåra Kejsarhamnen", "59°57,78' P, 22°21,84' I", 30, "Lähestymme Högsåraa Kasnäsin suunnalta koillisstuulessa, joka puhaltaa 13 – 15 m/s ja puuskissa rapiat päälle. Tällä tuulen suunnalla ei kannata mennä saaren pohjoisrannan satamaan eli Kejsarhamniin. Itäpuolella, kylän lahdella, on kaksikin satamaa: perinteinen kyläsatama, joka kulkee nykyisin nimellä Lillbackan laituri sekä Cafébryggan", harbourType1, null);

			harbourRepository.save(HögsåraKejsarhamnen);

			Harbour Vänö = new Harbour("Vänö", "59°52,1' P, 22°12,0' I", 35, "Saaristomeren eteläreunalla, Kansallispuiston kupeessa, on Vänön 1300-luvulta peräisin oleva kalastajakylä. Kalastajista ei ole enää tietoakaan, mutta saaren rannassa aistii vielä satoja vuotta vanhan saaristolaiskulttuurin. Siitä muistuttavat Vänön ikivanhat kalastustilojen talot ja rannan pikkuhiljaa lahoavat kalastusveneet. Nykypäivää edustaa puolestaan aktiivinen kyläyhdistys, sekä kesämökkiläisten ja veneilijöiden hyörinä laitureilla. Kun Vänötä lähestyy Jurmoon vievää jäänmurtajaväylää pitkin, näyttää kuin saari olisi tyystin autio ja asumaton. Se ei ole ihme, sillä kyläyhteisö ja satama on rakennettu Vänön etelärannalle. Satamaan on helppo navigoida 2,4 metrin väylää pitkin, joka erkanee Söder Lederklobbenin länsipuolelta lounaaseen. Ölonskärin pohjoispuolella oleva neljä metriä korkea vihreä reunamerkki on syytä pitää tiukasti styyrpuurissa, sillä Vänön itäranta on varsin kivikkoista.", harbourType1, null);

			harbourRepository.save(Vänö);

			Harbour Jurmo = new Harbour("Jurmo(Korppoo)", "59°49,63' P, 21°35,1' I", 80, "Jurmon luonnon karu romantiikkaa vetää saarelle vuosittain tuhansia matkailijoita. Ruuhka-aikaan heinäkuussa saaren vierassatamassa yöpyy päivittäin jopa 90 purje- ja moottorivenettä, ja saaren ainutlaatuinen luonto kiehtoo luontoharrastajia, lintubongareita ja retkeilijöitä. Vieraille vuokrataan saarella myös muutamaa mökkiä. Jurmon nummimaista maisemaa hallitsevat matala, sinipunaisena kukkiva kanervikko ja kullankeltaisena lainehtiva niitty. Silmä kantaa esteettä aina horisonttiin asti. Laakeassa maisemassa on jotain käsittämättömän rauhoittavaa", harbourType1, null);

			harbourRepository.save(Jurmo);

			Harbour Utö = new Harbour("Utö", "59°46,9' P, 21°22,4' I", 15, "Kylän puulaiturin itäinen puoli on varattu vierasvenesatamaksi. Länsipuoli ja pohjoinen pääty on luotsilaitoksen, sekä hotellin käytössä. ", harbourType1, null);

			harbourRepository.save(Utö);

			Harbour Nauvo = new Harbour("Nauvo, Nagu Hamn", "60°11,6' P, 21°55,0' I", 120, "udistetussa Nauvon satamassa on nyt uudet pidennetyt laiturit ja satamamuuria on kunnostettu. Talven 2020 aikana satamaan on rakennettu tiskauspaikat ja grillipaikka on saanut uuden ilmeen. Satamakonttorina toimii nyt laiturin ja rannan välissä kelluva ponttonitalo.", harbourType1, null);

			harbourRepository.save(Nauvo);

			Harbour Gullkrona = new Harbour("Gullkrona", "60°05,34' P, 23°04,9' I", 40, "Vuosikymmenen tauon jälkeen monelle niin rakas Gullkrona on auki jälleen. Parasta on, että lähes kaikki on ennallaan. Saara ja hänen miehensä Ilkka Herlin ostivat Gullkronan kalastajatilan Erikssonin perheeltä syksyllä 2016. Ajatuksena oli jo tuolloin avata satama jälleen kaikkien veneilijöiden iloksi, mutta ensin Erikssonin vanhan pariskunnan annettiin asua rauhassa vanhassa kodissaan niin kauan kuin se oli kunnon puolesta mahdollista.", harbourType1, null);

			harbourRepository.save(Gullkrona);

			Harbour Björkö = new Harbour("Björkö", "59°54,5' P, 21°40,80' I", null, "Eteläisellä Saaristomerellä sijaitseva Björkö on ainutlaatuinen. Syvälle työntyvä satamalahti antaa loistavan suojan, paitsi lounaistuulilta. Karu ulkosaariston luonto on upea, ja kaiken kruunaa harvinainen sisäjärvi. Metsähallitus on viitoittanut luontopolun, ja Pidä Saaristo Siistinä -yhdistyksen roskis, puucee sekä septintyhennys täydentävät retkisataman palveluja.", harbourType2, null);

			harbourRepository.save(Björkö);

			// saving harbours

			log.info("fetch");

			wc.addHarbours(harbour2);
			polttoaine.addHarbours(harbour2);
			sauna.addHarbours(harbour2);
			kahvila.addHarbours(harbour2);
			uimaranta.addHarbours(harbour2);
			yhteysalus.addHarbours(harbour2);

			wc.addHarbours(harbour1);
			polttoaine.addHarbours(harbour1);
			kahvila.addHarbours(harbour1);
			majoitus.addHarbours(harbour1);
			maasähkö.addHarbours(harbour1);
			septi.addHarbours(harbour1);
			sauna.addHarbours(harbour1);
			alko.addHarbours(harbour1);
			veneramppi.addHarbours(harbour1);
			ravintola.addHarbours(harbour1);

			wc.addHarbours(jussarö);
			polttoaine.addHarbours(jussarö);
			kahvila.addHarbours(jussarö);
			majoitus.addHarbours(jussarö);
			maasähkö.addHarbours(jussarö);
			septi.addHarbours(jussarö);
			sauna.addHarbours(jussarö);
			alko.addHarbours(jussarö);
			veneramppi.addHarbours(jussarö);
			ravintola.addHarbours(jussarö);




			wc.addHarbours(HögsåraKejsarhamnen);
			suihku.addHarbours(HögsåraKejsarhamnen);
			// polttoaine
			sauna.addHarbours(HögsåraKejsarhamnen);
			grillipaikka.addHarbours(HögsåraKejsarhamnen);
			juomavesi.addHarbours(HögsåraKejsarhamnen);
			// kahvila
			// leikkipaikka
			// luontopolku
			// majoitus
			// nahtavaa
			// uimaranta
			// yhteysalus
			// alko
			// ruokakauppa
			// ravintola
			// pesutupa
			// septi
			// veneramppi
			// apteekki
			// maasähkö

			serviceRepository.save(wc);
			serviceRepository.save(polttoaine);
			serviceRepository.save(sauna);
			serviceRepository.save(suihku);
			serviceRepository.save(grillipaikka);
			serviceRepository.save(juomavesi);
			serviceRepository.save(kahvila);
			serviceRepository.save(leikkipaikka);
			serviceRepository.save(luontopolku);
			serviceRepository.save(majoitus);
			serviceRepository.save(nahtavaa);
			serviceRepository.save(uimaranta);
			serviceRepository.save(yhteysalus);
			serviceRepository.save(alko);
			serviceRepository.save(ruokakauppa);
			serviceRepository.save(ravintola);
			serviceRepository.save(pesutupa);
			serviceRepository.save(septi);
			serviceRepository.save(veneramppi);
			serviceRepository.save(apteekki);
			serviceRepository.save(maasähkö);

			// save users
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			

			user1.addFavoriteHarbour(harbour2);


			user1.setUserType(userType2);
			user2.setUserType(userType2);
			user3.setUserType(userType1);

			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
		};
	}

}
