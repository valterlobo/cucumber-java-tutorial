package feature.book;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hascode.tutorial.cucumber.book.Book;
import com.hascode.tutorial.cucumber.book.Library;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookSaveSteps {
	
	
	 List<Book> books = new  ArrayList<>();
	 Library library = new Library();
	
	@Given(".+book title '(.+)', written by '(.+)', published in (.+)")
   public void addNewBook(final String title, final String author, @Format("dd MMMMM yyyy") final Date published) {
		Book book = new Book(title, author, published);
		books.add(book);
	}
  
  @When("^the customer save books$")
  public void the_customer_save_books() throws Throwable {
	  
	  for (Book book:books)
		  library.addBook(book);
  }



  @Then("(\\d+) books saved have been found$")
  public void verifyAmountOfBooksFound(final int booksFound) {
		assertThat(library.sizeBooks(), equalTo(booksFound));
   }
  
  @Then("Book (\\d+) saved have the title '(.+)'$")
	public void verifyBookAtPositionWord(final int position, final String title) {
		assertThat(library.getBook(position - 1).getTitle(), equalTo(title));
	}



}
