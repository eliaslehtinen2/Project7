package main;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Kirjastossa ei ole kirjoja");
            return;
        }

        int totalBooks = 0;
        for (Book book : books) {
            book.displayInfo();
            totalBooks += book.getCopies();
        }
        System.out.println("Kirjojen määrä kirjastossa on: " + totalBooks);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }
}
       
