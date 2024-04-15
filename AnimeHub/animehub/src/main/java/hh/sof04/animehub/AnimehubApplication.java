package hh.sof04.animehub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof04.animehub.domain.Anime;
import hh.sof04.animehub.domain.AnimeRepository;
import hh.sof04.animehub.domain.Category;
import hh.sof04.animehub.domain.CategoryRepository;
import hh.sof04.animehub.domain.User;
import hh.sof04.animehub.domain.UserRepository;

@SpringBootApplication
public class AnimehubApplication {

	private static final Logger log = LoggerFactory.getLogger(AnimehubApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AnimehubApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository categoryRepository, AnimeRepository animeRepository, UserRepository userRepository){
		return (args) -> {

			Category romance = new Category("Romance");
			Category horror = new Category("Horror");
			Category drama = new Category("Drama");

			categoryRepository.save(romance);
			categoryRepository.save(horror);
			categoryRepository.save(drama);

			animeRepository.save(new Anime("One piece", 1100, 9.10, horror));
			animeRepository.save(new Anime("Frieren", 28, 9.78, drama));
			animeRepository.save(new Anime("Solo Leveling", 13, 9.10, romance));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);

			log.info("Fetch Categories");
			for (Category category : categoryRepository.findAll()) {
                log.info(category.toString());

			log.info("------------------------------");

            log.info("Fetch Animes");
            for (Anime anime : animeRepository.findAll()) {
                log.info(anime.toString());
            	}
			log.info("------------------------------");
            }
		};
	}

}
