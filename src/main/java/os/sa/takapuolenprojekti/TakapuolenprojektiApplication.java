package os.sa.takapuolenprojekti;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import os.sa.takapuolenprojekti.domain.Book;
import os.sa.takapuolenprojekti.domain.BookRepository;

@SpringBootApplication
public class TakapuolenprojektiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TakapuolenprojektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b = new Book("Harry Potter ja viisasten kivi", "J.K Rowling", 2018, "9789520401801", "24,95");
			Book c = new Book("Harry Potter ja salaisuuksien kammio", "J.K Rowling", 2021, "9789520433543", "32,95");
			Book d = new Book("Harry Potter ja Feeniksin kilta (kuvitettu)", "J.K Rowling", 2022, "9789513187064", "36,95");

			repository.save(b);
			repository.save(c);
			repository.save(d);
		};

	}

}
