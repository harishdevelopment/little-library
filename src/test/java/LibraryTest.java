import com.littlelibrary.exception.BookNotAvailableException;
import com.littlelibrary.operations.BorrowBook;
import com.littlelibrary.operations.HoldBook;
import com.littlelibrary.operations.Operations;
import com.littlelibrary.operations.ReturnBook;
import com.littlelibrary.repository.LibraryRepository;
import com.littlelibrary.repository.LibraryRepositoryImpl;
import com.littlelibrary.types.BookStatus;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    LibraryRepository libraryBooks = new LibraryRepositoryImpl();

    @Before
    public void setUp() throws Exception {
        libraryBooks.addBook("Book 1");
        libraryBooks.addBook("Book 2");
        libraryBooks.addBook("Book 3");
    }

    @Test
    public void borrowBook() throws Exception {
        Operations operation = new BorrowBook("Book 1");
        operation.performOperation(libraryBooks);
        assertEquals(libraryBooks.getBookStatus("Book 1"), BookStatus.ISSUED);
    }

    @Test(expected = BookNotAvailableException.class)
    public void borrowSameBookMultipleTimes() throws Exception {
        Operations operation = new BorrowBook("Book 1");
        operation.performOperation(libraryBooks);
        assertEquals(libraryBooks.getBookStatus("Book 1"), BookStatus.ISSUED);
        operation = new BorrowBook("Book 1");
        operation.performOperation(libraryBooks);
    }

    @Test
    public void borrowAndReturnBook() throws Exception {
        Operations operation = new BorrowBook("Book 1");
        operation.performOperation(libraryBooks);
        assertEquals(libraryBooks.getBookStatus("Book 1"), BookStatus.ISSUED);
        operation = new ReturnBook("Book 1");
        operation.performOperation(libraryBooks);
        assertEquals(libraryBooks.getBookStatus("Book 1"), BookStatus.AVAILABLE);
    }

    @Test(expected = BookNotAvailableException.class)
    public void borrowABookOnHold() throws Exception {
        Operations operation = new HoldBook("Book 1");
        operation.performOperation(libraryBooks);
        assertEquals(libraryBooks.getBookStatus("Book 1"), BookStatus.HOLD);
        operation = new BorrowBook("Book 1");
        operation.performOperation(libraryBooks);
    }

    @Test
    public void viewLibraryStatus() throws Exception {
        Operations operation = new HoldBook("Book 1");
        operation.performOperation(libraryBooks);
        operation = new BorrowBook("Book 2");
        operation.performOperation(libraryBooks);
        Map libraryBooks = this.libraryBooks.getLibraryStatus();
        libraryBooks.forEach((k, v) -> System.out.println("Book Title : " + k + " BookStatus : " + v));
    }


}
