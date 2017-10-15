package zajecia.dziewiate;

import java.util.ArrayList;

/**
 * Created by RENT on 2017-02-11.
 */
public class Bookshelf {
    private ArrayList<Book> books;

    public Bookshelf() {
        this.books = new ArrayList<>();
    }

    public Book get(int index) {
        if (index >= 0 && index < books.size()) {
            return this.books.get(index);
        }
        return null;
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public ArrayList<Book> getBooksOf(String author) {
        author = author.toLowerCase();
        ArrayList<Book> booksTmp = new ArrayList<>();

//        FOR EACH
//        iteruj po wszystkich elem books i kazdego zapisuj do elementu book
//        dla kazdego elementu w kolekcji books rob:
        for (Book book : books) {
            Author authorOfBook = book.getAuthor();
            String firstNameOfBookAuthor = authorOfBook.getFirstName().toLowerCase();
            String lastNameOfBookAuthor = authorOfBook.getLastName().toLowerCase();

            boolean searchRequirement =
                    firstNameOfBookAuthor.startsWith(author) ||
                    lastNameOfBookAuthor.startsWith(author) ||
                    (lastNameOfBookAuthor + " " + firstNameOfBookAuthor).startsWith(author) ||
                    authorOfBook.toString().toLowerCase().startsWith(author);
            if (searchRequirement) {
                booksTmp.add(book);
            }
        }
        return booksTmp;
    }

    public ArrayList<Book> getBooksFrom(int releaseDate) {
        ArrayList<Book> booksTmp = new ArrayList<>();
        for (Book book : books) {
            if (book.getReleaseDate() == releaseDate) {
                booksTmp.add(book);
            }
        }
        return booksTmp;
    }

    public ArrayList<Book> getBooksSince(int releaseDate) {
        ArrayList<Book> booksTmp = new ArrayList<>();
        for (Book book : books) {
            if (book.getReleaseDate() >= releaseDate) {
                booksTmp.add(book);
            }
        }
        return booksTmp;
    }

    public ArrayList<Book> getBooksLongerThan(int numberOfPages) {
        ArrayList<Book> booksTmp = new ArrayList<>();
        for (Book book : books) {
            if (book.getNumberOfPages() >= numberOfPages) {
                booksTmp.add(book);
            }
        }
        return booksTmp;
    }

}
