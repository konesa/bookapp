package com.BookStore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

import com.BookStore.web.*;

@SpringBootTest
class BookStoreApplicationTests {
	
	@Autowired
	private AddBookController controller1;
	@Autowired
	private BookEditController controller2;
	@Autowired
	private DeleteController controller3;
	@Autowired
	private GetBookByIdRestController controller4;
	@Autowired
	private IndexController controller5;
	@Autowired
	private ListController controller6;
	@Autowired
	private ListControllerRest controller7;
	@Autowired
	private LoginController controller8;

	@Test
	void contextLoads() throws Exception{
		assertThat(controller1).isNotNull();
		assertThat(controller2).isNotNull();
		assertThat(controller3).isNotNull();
		assertThat(controller4).isNotNull();
		assertThat(controller5).isNotNull();
		assertThat(controller6).isNotNull();
		assertThat(controller7).isNotNull();
		assertThat(controller8).isNotNull();
	}
}