package pl.sda.builder;

//    POJO Plain Old Java Object - potoczne okreslenie na klase, ktora ma tylko pola, gettery i settery

public class Person {

//    klasa reprezentujaca osobe
//    do niej stworzymy buildera

    private String firstName;
    private String lastName;
    private PersonAddress address;
    private String pesel;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonAddress getAddress() {
        return address;
    }

    public void setAddress(PersonAddress address) {
        this.address = address;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
