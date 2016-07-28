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

public class BookDeleteSteps {
		
		
	 
	  Library library = new Library();
		
	   @Given(".+book: title '(.+)', written by '(.+)', published in (.+)")
	   public void addBookDelete(final String title, final String author, @Format("dd MMMMM yyyy") final Date published) {
			Book book = new Book(title, author, published);
			library.addBook(book);
		}
	  
	  @When("^the ADMIN delete book whith title '(.+)'$")
	  public void the_admin_delete_books(String title) throws Throwable {		  
		  List<Book> result =library.findBooks(title);
		  library.deleteBook(result.get(0));
	  }



	  @Then("(\\d+) books have been found$")
	  public void verifyAmountOfBooksFound(final int booksFound) {
			assertThat(library.sizeBooks(), equalTo(booksFound));
	   }
	  
	  @Then("Book (\\d+)  have the title '(.+)'$")  //Book 1  have the title 'One good book
		public void verifyBookAtPositionWord(final int position, final String title) {
			assertThat(library.getBook(position - 1).getTitle(), equalTo(title));
		}


}
