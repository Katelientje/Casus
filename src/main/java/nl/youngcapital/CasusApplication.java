package nl.youngcapital;

import nl.youngcapital.domain.User;
import nl.youngcapital.domain.UserWeight;
import nl.youngcapital.repository.UserRepository;
import nl.youngcapital.service.UserService;
import nl.youngcapital.service.UserWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class CasusApplication implements ApplicationRunner {
	@Autowired
	UserWeightService userWeightService;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CasusApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = createUser("Henk", "Henk@devries.nl", "M", 171.0f);
		createUserWeight(80.0f, user, "2019-05-15");
		createUserWeight(76.0f, user, "2019-06-10");
		createUserWeight(70.0f, user, "2019-07-20");
		createUserWeight(66.0f, user, "2019-08-18");
		createUserWeight(70.0f, user, "2019-09-03");
		createUserWeight(85.0f, user, "2019-10-20");

	}

	public User createUser(String n, String e, String s, Float l){
		User user = new User(n, e, s, l);
		return userService.save(user);
	}
	public UserWeight createUserWeight(Float f, User u, String d){
		UserWeight userWeight = new UserWeight(f, u, d);
		return userWeightService.save(userWeight);
	}

/*	Test to see if the database is being filled
*
* 	@Bean
*	CommandLineRunner init(UserRepository userRepository) {
*		return args -> {
*			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
*				User user = new User(name, name.toLowerCase() + "@domain.com");
*				userRepository.save(user);
*   		});
*			userRepository.findAll().forEach(System.out::println);
*		};
*	}
*/
}
