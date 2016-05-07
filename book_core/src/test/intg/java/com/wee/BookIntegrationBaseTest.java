package test.intg.java.com.wee;

import main.java.com.wee.BookApiApplication;
import main.java.com.wee.entity.BookEntity;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = BookApiApplication.class)
@Transactional
@TransactionConfiguration
public abstract class BookIntegrationBaseTest {

	protected static final String BOOK_NAME = "Head First Java";
	protected static final Long BOOK_ID = 123456L;
	protected static final Long BOOK_ID_1 = 654321L;
	protected static final String BOOK_AUTHOR = "Bert Bates";
	protected static final String BOOK_AUTHOR_1 = "Paul Barry";
	protected static final String BOOK_YEAR = "2003";
	protected static final String BOOK_YEAR_1 = "2010";

	protected MockMvc mockMvc;


	protected BookEntity givenActiveBookEntity(Long bookId) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookId(bookId);
		bookEntity.setName(BOOK_NAME);
		bookEntity.setAuthor(BOOK_AUTHOR);
		bookEntity.setYear(BOOK_YEAR);
		bookEntity.setActive(true);
		return bookEntity;
	}

	protected BookEntity givenInActiveBookEntity(Long bookId) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookId(bookId);
		bookEntity.setName(BOOK_NAME);
		bookEntity.setAuthor(BOOK_AUTHOR_1);
		bookEntity.setYear(BOOK_YEAR_1);
		bookEntity.setActive(false);
		return bookEntity;
	}
}
