package pl.sda.builder;

public class Main {
    public static void main(String[] args) {

//        tworzymy buildera

        PersonBuilder personBuilder = new PersonBuilder();

//        tworzymy obiekt budowany:

        PersonAddress address = new PersonAddress();
        address.setCity("Poznan");
        address.setStreet("Baraniaka 88");
        address.setPostalCode("60-111");

        Person person = personBuilder.withFirstName("Jan").withLastName("Kowalski")
                .withPesel("95020301890").withPersonAddress(address)
                .build();

//        zeby wywolac musimy miec toString w Person i w PersonAddress

        System.out.println(person.toString());

    }
}
