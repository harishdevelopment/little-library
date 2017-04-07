package com.littlelibrary.repository;

import com.littlelibrary.exception.BookNotAvailableException;
import com.littlelibrary.types.BookStatus;

import java.util.HashMap;
import java.util.Map;

public class LibraryRepositoryImpl implements LibraryRepository {

    private Map<String, BookStatus> libraryBooks;

    public LibraryRepositoryImpl() {
        this.libraryBooks = new HashMap<>();
    }

    @Override
    public void addBook(String bookTitle) {
        libraryBooks.put(bookTitle, BookStatus.AVAILABLE);
    }

    @Override
    public void updateBookStatus(String bookTitle, BookStatus bookStatus){
        if(libraryBooks.containsKey(bookTitle)){
            libraryBooks.put(bookTitle, bookStatus);
        } else {
            throw new BookNotAvailableException();
        }
    }

    @Override
    public BookStatus getBookStatus(String bookTitle){
        if(libraryBooks.containsKey(bookTitle)){
            return libraryBooks.get(bookTitle);
        } else {
            throw new BookNotAvailableException();
        }
    }

    @Override
    public Map getLibraryStatus(){
        return libraryBooks;
    }
}
