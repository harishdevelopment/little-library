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
    }
}
