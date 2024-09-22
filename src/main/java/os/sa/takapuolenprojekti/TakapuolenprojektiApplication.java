package os.sa.takapuolenprojekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import os.sa.takapuolenprojekti.domain.Book;
import os.sa.takapuolenprojekti.domain.BookRepository;
import os.sa.takapuolenprojekti.domain.Category;
import os.sa.takapuolenprojekti.domain.CategoryRepository;

@SpringBootApplication
public class TakapuolenprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(TakapuolenprojektiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TakapuolenprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Muutama testikirja");
			Book b = new Book("Harry Potter ja viisasten kivi", "J.K Rowling", 2018, "9789520401801", "24,95");
			Book c = new Book("Harry Potter ja salaisuuksien kammio", "J.K Rowling", 2021, "9789520433543", "32,95");
			Book d = new Book("Harry Potter ja Feeniksin kilta (kuvitettu)", "J.K Rowling", 2022, "9789513187064", "36,95");

			log.info("Muutama testikategoria");
			Category category1 = new Category("Fantasia");
			Category category2 = new Category("Kauhu");
			Category category3 = new Category("Rikos");

			repository.save(b);
			repository.save(c);
			repository.save(d);

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			log.info("Luodut kategoriat:");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
		};

	}

}
