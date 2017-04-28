package pl.sda.builder;


public class PersonBuilder {

//    odniesienie na obiekt budowany
    private Person person;

//    konstruktor tworzacy nowy obiekt klasy person


    public PersonBuilder() {
        person = new Person();
    }

//    kilka metod zwracajacych buildera o nazwach np.: withFirstName
//    metody zwracajace obiekt buildera - this
//    zwraca sam siebie
//    with jest czescia konwencji

    public PersonBuilder withFirstName (String firstName) {
        person.setFirstName(firstName);
        return this;
    }

    public PersonBuilder withLastName (String lastName) {
        person.setLastName(lastName);
        return this;
    }

    public PersonBuilder withPersonAddress (PersonAddress personAddress) {
        person.setAddress(personAddress);
        return this;
    }

    public PersonBuilder withPesel (String pesel) {
        person.setPesel(pesel);
        return this;
    }

//    metoda zwracajaca obiekt budowany
//    zwyczajowo nazywana build - zwraca obiekt zaw pola obiekty budowanego

    public Person build() {
        return person;
    }

}
