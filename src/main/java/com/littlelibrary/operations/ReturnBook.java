package com.littlelibrary.operations;

import com.littlelibrary.repository.LibraryRepository;
import com.littlelibrary.types.BookStatus;

public class ReturnBook implements Operations {

    private String bookTitle;

    public ReturnBook(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public void performOperation(LibraryRepository libraryRepositoryImpl) {
        libraryRepositoryImpl.updateBookStatus(bookTitle, BookStatus.AVAILABLE);
        System.out.println(bookTitle + " has been returned");

        // Store the fine in the repository against the user
        calculateAndStoreFine(libraryRepositoryImpl);
    }

    /*
      This method is dummy as we are not tracking the book issue dates
      Detail implementation will require detailed repository model
     */
    private void calculateAndStoreFine(LibraryRepository libraryRepositoryImpl) {
        System.out.println("Fine calculated when books are returned");
    }
}
