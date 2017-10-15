package zajecia.dziewiate;

/**
 * Created by RENT on 2017-02-11.
 */
public class User {
    public String firstName;
    public String lastName;
    public String birthDate;
    public Address address;

//  konstruktor defaultowy/domyslny/pusty
    public User() {

    }

    public User(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public User(String firstName, String lastName, String birthDate, Address address) {
//      odwołanie do konstruktora, ktory juz istnieje
        this(firstName, lastName, birthDate);
        this.address = address;
//        this.address = new Address(); (mozna tez podac tutaj, albo w Address wartosci defaultowe
    }

    public void print() {
        System.out.println(firstName + " " + lastName + ", born in: " + birthDate);
        if (address != null) {
            address.printAdress();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
