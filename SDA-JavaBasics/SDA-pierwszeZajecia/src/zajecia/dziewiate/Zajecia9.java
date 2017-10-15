package zajecia.dziewiate;

import java.util.ArrayList;

/**
 * Created by RENT on 2017-02-11.
 */
public class Zajecia9 {
    public static void main(String[] args) {
//      Cwiczenia z klasa Book i Bookshelf
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        Bookshelf bookshelf = new Bookshelf();

        Author henrykSienkiewicz = new Author("Henryk", "Sienkiewicz");
        Author adamMickiewicz = new Author("Adam", "Mickiewicz");

        Book book = new Book("Krzyzacy",henrykSienkiewicz, 2003, message.split(" "));
        bookshelf.add(book);

        Book book2 = new Book("Ogniem i mieczem", henrykSienkiewicz, 2003, message.split(" "));
        Book book3 = new Book("Pan Wolodyjowski", henrykSienkiewicz, 1993, message.split(" "));
        Book book4 = new Book("Dziady", adamMickiewicz, 2010, message.split(" "));
        bookshelf.add(book2);
        bookshelf.add(book3);
        bookshelf.add(book4);

        ArrayList<Book> booksOf = bookshelf.getBooksOf("mic");
        for (Book b : booksOf) {
            System.out.println(b.toString());
        }

        System.out.println();

        for (Book a : bookshelf.getBooksFrom(2000)) {
            System.out.println(a.toString());
        }

        System.out.println();

        for (Book c : bookshelf.getBooksSince(2002)) {
            System.out.println(c.toString());
        }

        System.out.println();

        for (Book d : bookshelf.getBooksLongerThan(5)) {
            System.out.println(d.toString());
        }

        System.out.println();


        /*
        book.setCategory("historical");
        book.setDescription("classic");

        String page = book.getPage(5);
        System.out.println(page);
        */

        /*
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book());
        */

//      Czytanie stron ksiazki:
        /*
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < book.getNumberOfPages(); i++) {
            System.out.println(book.getPage(i + 1));
            System.out.println("Enter when you finish");
            String s = sc.nextLine()
        }
        */

        System.out.println();

//      Cwiczenia z klasami User i Address
        User user1 = new User();

//      Ponizsze, jak nie ma konstruktora z argumentami:
        user1.firstName = "Marta";
        user1.lastName = "M-B";
        user1.birthDate = "18.03.1086";

        Address address1 = new Address("Poznanska", 3, "53-344", "Poznan", "Poland");
        user1.address = address1;

        user1.print();

        System.out.println();

        Address address2 = new Address("Lesna", 25, "33-444", "Puszcza", "Poland");
//      Z wykorzystaniem konstruktora z argumentami:
        User user2 = new User("Jan", "Kowalski", "03.09.1004", address2);
        user2.print();

        /*
        User[] users = new User[2];
        users[0] = user1;
        users[1] = user2;

        System.out.println("Array of users: ");
        printUsers(users);
        */

    }

    public static void printUsers(User[] users) {
        for (int i = 0; i < users.length; i++) {
            users[i].print();
        }
    }
}
