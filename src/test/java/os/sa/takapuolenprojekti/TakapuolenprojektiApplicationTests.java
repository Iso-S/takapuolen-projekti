package os.sa.takapuolenprojekti;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;

import os.sa.takapuolenprojekti.web.BookController;
import os.sa.takapuolenprojekti.web.BookRestController;
import os.sa.takapuolenprojekti.web.CategoryController;

@SpringBootTest
class TakapuolenprojektiApplicationTests {

	@Autowired
	private BookController controller;

		@Test
		public void contextLoads() throws Exception {
			assertThat(controller).isNotNull();
		}

	@Autowired
	private CategoryController controller2;

		@Test
		public void contextLoads2() throws Exception {
			assertThat(controller2).isNotNull();
		}

	@Autowired
	private BookRestController controller3;

		@Test
		public void contextLoads3() throws Exception {
			assertThat(controller3).isNotNull();
		}
}
