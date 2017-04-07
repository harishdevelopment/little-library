package com.littlelibrary.operations;

import com.littlelibrary.repository.LibraryRepository;
import com.littlelibrary.exception.BookNotAvailableException;
import com.littlelibrary.types.BookStatus;

public class BorrowBook implements Operations {

    private String bookTitle;

    public BorrowBook(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public void performOperation(LibraryRepository libraryRepository) {
        if(libraryRepository.getBookStatus(bookTitle) == BookStatus.AVAILABLE) {
            libraryRepository.updateBookStatus(bookTitle, BookStatus.ISSUED);
            System.out.println(bookTitle + " has been issued");
        } else {
            throw new BookNotAvailableException();
        }
    }
}
