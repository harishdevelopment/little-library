package com.littlelibrary.operations;

import com.littlelibrary.exception.BookNotAvailableException;
import com.littlelibrary.repository.LibraryRepository;
import com.littlelibrary.types.BookStatus;

public class HoldBook implements Operations {

    private String bookTitle;

    public HoldBook(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public void performOperation(LibraryRepository libraryRepository) {
        if (libraryRepository.getBookStatus(bookTitle) == BookStatus.AVAILABLE) {
            libraryRepository.updateBookStatus(bookTitle, BookStatus.HOLD);
            System.out.println(bookTitle + " has been put on hold");
        } else {
            throw new BookNotAvailableException();
        }
    }
}
