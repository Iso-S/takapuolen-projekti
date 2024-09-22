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
			log.info("Muutama testikategoria");
			Category category1 = new Category("Fantasia");
			Category category2 = new Category("Kauhu");
			Category category3 = new Category("Rikos");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			repository.save(new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 1997, "9789510316893", "20,00", category1));
			repository.save(new Book("Harry Potter ja salaisuuksien kammio", "J.K. Rowling", 1998, "9789510316909", "20,00", category1));
			repository.save(new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 1999, "9789510316916", "20,00", category1));

			log.info("Luodut kategoriat:");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}

			log.info("Luodut kirjat:");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};

	}

}
