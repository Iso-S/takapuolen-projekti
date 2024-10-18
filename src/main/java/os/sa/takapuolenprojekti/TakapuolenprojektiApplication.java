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
import os.sa.takapuolenprojekti.domain.Users;
import os.sa.takapuolenprojekti.domain.UsersRepository;

@SpringBootApplication
public class TakapuolenprojektiApplication {

	private static final Logger log = LoggerFactory.getLogger(TakapuolenprojektiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(TakapuolenprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UsersRepository urepository) {
		return (args) -> {
			log.info("Muutama testikategoria");
			Category category1 = new Category("Fantasia");
			Category category2 = new Category("Kauhu");
			Category category3 = new Category("Rikos");

			crepository.save(category1);
			crepository.save(category2);
			crepository.save(category3);

			repository.save(new Book("Harry Potter ja viisasten kivi", "J.K. Rowling", 1997, "9789510316893", "21,00", category1));
			repository.save(new Book("Harry Potter ja salaisuuksien kammio", "J.K. Rowling", 1998, "9789510316909", "22,00", category1));
			repository.save(new Book("Harry Potter ja Azkabanin vanki", "J.K. Rowling", 1999, "9789510316916", "23,00", category1));

			Users user1 = new Users ("user", "$2a$10$nAckPIKVHRpUm8Ilk6JkQe7/Rk6UddaGzYKDN.h7z.45T2BIFjpju", "USER", "user@gotmail.net");
			Users user2 = new Users ("admin", "$2a$10$nAckPIKVHRpUm8Ilk6JkQe7/Rk6UddaGzYKDN.h7z.45T2BIFjpju", "ADMIN", "test@email.com");
			
			urepository.save(user1);
			urepository.save(user2);
		};
	}
}
