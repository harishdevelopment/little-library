package com.littlelibrary.repository;

import com.littlelibrary.types.BookStatus;

import java.util.Map;

public interface LibraryRepository {
    void addBook(String bookTitle);

    void updateBookStatus(String bookTitle, BookStatus bookStatus);

    BookStatus getBookStatus(String bookTitle);

    Map getLibraryStatus();
}
